package com.example.chowbattle.event;

import com.example.chowbattle.ChowBattleMod;
import com.example.chowbattle.entity.EntityMod;
import com.example.chowbattle.entity.sam.SamuelEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChowBattleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventBusEventsMod {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityMod.SAMUEL.get(), SamuelEntity.createAttributes().build());
    }
}