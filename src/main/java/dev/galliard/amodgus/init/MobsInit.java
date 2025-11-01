package dev.galliard.amodgus.init;

import dev.galliard.amodgus.entities.AmongusEntity;
import dev.galliard.amodgus.entities.ImpostorEntity;
import dev.galliard.amodgus.Amodgus;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MobsInit {
	public static final DeferredRegister<EntityType<?>> MOBS =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Amodgus.MODID);
	
	public static final RegistryObject<EntityType<AmongusEntity>> AMONGUS =
			MOBS.register("amongus", 
					() -> EntityType.Builder.of(AmongusEntity::new, MobCategory.CREATURE)
					.sized(0.4f, 1.0f)
					.build(new ResourceLocation(Amodgus.MODID,"amongus").toString()));
	
	public static final RegistryObject<EntityType<ImpostorEntity>> IMPOSTOR =
			MOBS.register("impostor", 
					() -> EntityType.Builder.of(ImpostorEntity::new, MobCategory.MONSTER)
					.sized(0.4f, 1.0f)
					.build(new ResourceLocation(Amodgus.MODID,"impostor").toString()));
		
	public static void register(IEventBus eventBus) {
		MOBS.register(eventBus);
	}
}
