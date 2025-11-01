package dev.galliard.amodgus.entities;

import dev.galliard.amodgus.entities.variant.AmongusVariant;
import org.jetbrains.annotations.Nullable;

import dev.galliard.amodgus.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ImpostorEntity extends Monster implements IAnimatable {
	@SuppressWarnings("removal")
	private AnimationFactory factory = new AnimationFactory(this);
	
	private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(ImpostorEntity.class, EntityDataSerializers.INT);
	
	public ImpostorEntity(EntityType<? extends Monster> entityType, Level world) {
		super(entityType, world);
		// TODO Apéndice de constructor generado automáticamente
	}
		
	public static AttributeSupplier setAttributes() {
		return TamableAnimal.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 14.00)
				.add(Attributes.ATTACK_DAMAGE,7.0f)
				.add(Attributes.ATTACK_SPEED,2.2f)
				.add(Attributes.MOVEMENT_SPEED, 0.5f).build();
	}
	
	@Override
	protected void registerGoals() {
	      this.goalSelector.addGoal(1, new FloatGoal(this));
	      this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
	      this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 6.0f));
	      this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
	      this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ImpostorEntity.class));
	      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Player.class, true));
	      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, AmongusEntity.class, false));
	}
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", (ILoopType)ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", (ILoopType)ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }
	
	private <E extends IAnimatable> PlayState deathPredicate(AnimationEvent<E> event) {
		if (this.isDeadOrDying()) {
			this.setHealth(0.5f);
			event.getController().setAnimation(new AnimationBuilder().addAnimation("death", (ILoopType)ILoopType.EDefaultLoopTypes.PLAY_ONCE));
			this.die(getLastDamageSource());
			return PlayState.CONTINUE;
		}
		return PlayState.CONTINUE;
	}
	
	@Override
    public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<IAnimatable>((IAnimatable)this, "controller", 0.0f, this::predicate));
		data.addAnimationController(new AnimationController<IAnimatable>((IAnimatable)this, "deathController", 0.0f, this::deathPredicate));
    }
	
    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
        
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.NETHERITE_BLOCK_PLACE, 0.15F, 1.0F);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.SHULKER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.AMONGUS_DEATH.get();
    }
        
    protected float getSoundVolume() {
        return 0.4F;
    }
		    
	@Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }
    
    /* VARIANTS */
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        AmongusVariant variant = AmongusVariant.BLACK;
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    public AmongusVariant getVariant() {
        return AmongusVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(AmongusVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
	
}
