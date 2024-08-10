package com.example.chowbattle.entity.sam;

import com.example.chowbattle.ChowBattleMod;
import com.example.chowbattle.entity.ModelLayersMod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SamuelRenderer extends MobRenderer<SamuelEntity, SamuelModel<SamuelEntity>> {
    public SamuelRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SamuelModel<>(pContext.bakeLayer(ModelLayersMod.SAM_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(SamuelEntity pEntity) {
        return new ResourceLocation(ChowBattleMod.MODID, "textures/entity/samuel.png");
    }

    @Override
    public void render(SamuelEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
