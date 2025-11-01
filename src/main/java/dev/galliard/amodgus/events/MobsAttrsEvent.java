package dev.galliard.amodgus.events;

import dev.galliard.amodgus.entities.AmongusEntity;
import dev.galliard.amodgus.entities.ImpostorEntity;
import dev.galliard.amodgus.Amodgus;
import dev.galliard.amodgus.init.MobsInit;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Amodgus.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MobsAttrsEvent {
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> SpawnPlacements.register(MobsInit.AMONGUS.get(), 
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AmongusEntity::canSpawn));
		event.enqueueWork(() -> SpawnPlacements.register(MobsInit.IMPOSTOR.get(), 
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Monster::checkMonsterSpawnRules));
	}
	
	@SubscribeEvent
	public static void entityAttributes(EntityAttributeCreationEvent event) {
		event.put(MobsInit.AMONGUS.get(), AmongusEntity.setAttributes());
		event.put(MobsInit.IMPOSTOR.get(), ImpostorEntity.setAttributes());
	}
	
}
