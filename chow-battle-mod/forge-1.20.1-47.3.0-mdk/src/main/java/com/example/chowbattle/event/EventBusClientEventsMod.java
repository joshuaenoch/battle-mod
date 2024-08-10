package com.example.chowbattle.event;

import com.example.chowbattle.ChowBattleMod;
import com.example.chowbattle.entity.ModelLayersMod;
import com.example.chowbattle.entity.sam.SamuelModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChowBattleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EventBusClientEventsMod {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelLayersMod.SAM_LAYER, SamuelModel::createBodyLayer);
    }
}