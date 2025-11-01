package dev.galliard.amodgus.client.renderer;

import java.util.Map;

import dev.galliard.amodgus.client.models.AmongusModel;
import dev.galliard.amodgus.entities.AmongusEntity;
import dev.galliard.amodgus.entities.variant.AmongusVariant;
import org.jetbrains.annotations.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import dev.galliard.amodgus.Amodgus;

import com.google.common.collect.Maps;

import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AmongusRenderer extends GeoEntityRenderer<AmongusEntity> {
	
	public static final Map<AmongusVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(AmongusVariant.class), (p_114874_) -> {
                p_114874_.put(AmongusVariant.RED,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_red.png"));
                p_114874_.put(AmongusVariant.YELLOW,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_yellow.png"));
                p_114874_.put(AmongusVariant.ORANGE,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_orange.png"));
                p_114874_.put(AmongusVariant.GREEN,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_green.png"));
                p_114874_.put(AmongusVariant.LIME,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_lime.png"));
                p_114874_.put(AmongusVariant.PURPLE,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_purple.png"));
                p_114874_.put(AmongusVariant.MAGENTA,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_magenta.png"));
                p_114874_.put(AmongusVariant.PINK,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_pink.png"));
                p_114874_.put(AmongusVariant.WHITE,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_white.png"));
                p_114874_.put(AmongusVariant.BLACK,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_black.png"));
                p_114874_.put(AmongusVariant.BROWN,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_brown.png"));
                p_114874_.put(AmongusVariant.BLUE,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_blue.png"));
                p_114874_.put(AmongusVariant.CYAN,
                        new ResourceLocation(Amodgus.MODID, "textures/entities/amongus_cyan.png"));

            });
	
	public AmongusRenderer(Context renderManager) {
		super(renderManager, new AmongusModel());
		// TODO Apéndice de constructor generado automáticamente
		this.shadowRadius = 0.5f;
	}
	
	
	
	@Override
	public ResourceLocation getTextureLocation(AmongusEntity object) {
		// TODO Apéndice de método generado automáticamente
		return LOCATION_BY_VARIANT.get(object.getVariant());
	}
	
	@Override
    public RenderType getRenderType(AmongusEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.0f, 1.0f, 1.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
	
}