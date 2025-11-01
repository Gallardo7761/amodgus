package dev.galliard.amodgus.client.models;

import dev.galliard.amodgus.entities.AmongusEntity;
import dev.galliard.amodgus.Amodgus;
import dev.galliard.amodgus.client.renderer.AmongusRenderer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AmongusModel extends AnimatedGeoModel<AmongusEntity> {

	@Override
	public ResourceLocation getModelResource(AmongusEntity object) {
		// TODO Apéndice de método generado automáticamente
		return new ResourceLocation(Amodgus.MODID, "geo/amongus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AmongusEntity object) {
		// TODO Apéndice de método generado automáticamente
		return AmongusRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
	}
	
	@Override
	public ResourceLocation getAnimationResource(AmongusEntity animatable) {
		// TODO Apéndice de método generado automáticamente
		return new ResourceLocation(Amodgus.MODID, "animations/amongus.animation.json");
	}
	
}