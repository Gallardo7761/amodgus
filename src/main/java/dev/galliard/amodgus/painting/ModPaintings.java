package dev.galliard.amodgus.painting;

import dev.galliard.amodgus.Amodgus;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
	public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, Amodgus.MODID);
	
	public static final RegistryObject<PaintingVariant> IMPOSTOR = PAINTING_VARIANTS.register("impostor",
			() -> new PaintingVariant(64,32));
	
	public static void register(IEventBus bus) {
		PAINTING_VARIANTS.register(bus);
	}
}
