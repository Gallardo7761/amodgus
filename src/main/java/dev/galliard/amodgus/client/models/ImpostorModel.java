package dev.galliard.amodgus.client.models;

import dev.galliard.amodgus.client.renderer.AmongusRenderer;
import dev.galliard.amodgus.entities.ImpostorEntity;
import dev.galliard.amodgus.Amodgus;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ImpostorModel extends AnimatedGeoModel<ImpostorEntity> {

	@Override
	public ResourceLocation getModelResource(ImpostorEntity object) {
		// TODO Apéndice de método generado automáticamente
		return new ResourceLocation(Amodgus.MODID, "geo/amongus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ImpostorEntity object) {
		// TODO Apéndice de método generado automáticamente
		return AmongusRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
	}
	
	@Override
	public ResourceLocation getAnimationResource(ImpostorEntity animatable) {
		// TODO Apéndice de método generado automáticamente
		return new ResourceLocation(Amodgus.MODID, "animations/amongus.animation.json");
	}
	
}