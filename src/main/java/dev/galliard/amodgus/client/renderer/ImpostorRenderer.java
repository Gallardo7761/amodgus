package dev.galliard.amodgus.client.renderer;

import dev.galliard.amodgus.entities.ImpostorEntity;
import org.jetbrains.annotations.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import dev.galliard.amodgus.Amodgus;
import dev.galliard.amodgus.client.models.ImpostorModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ImpostorRenderer extends GeoEntityRenderer<ImpostorEntity> {
	
	public ImpostorRenderer(Context renderManager) {
		super(renderManager, new ImpostorModel());
		// TODO Auto-generated constructor stub
		this.shadowRadius = 0.5f;
	}

	@Override
	public ResourceLocation getTextureLocation(ImpostorEntity object) {
		// TODO Apéndice de método generado automáticamente
		return new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_black.png");
	}
	
	@Override
    public RenderType getRenderType(ImpostorEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.0f, 1.0f, 1.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
	
}