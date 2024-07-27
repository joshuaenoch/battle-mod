package com.example.chowbattle;

import com.example.chowbattle.block.BlockMod;
import com.example.chowbattle.item.ItemMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TabMod {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChowBattleMod.MODID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("example_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.ENDER_CHEST.asItem()))
                    .title(Component.translatable("creativetab.example_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ItemMod.GLADIATOR_PACK.get());
                        pOutput.accept(ItemMod.SURVIVALIST_PACK.get());
                        pOutput.accept(ItemMod.NINJA_PACK.get());
                        pOutput.accept(ItemMod.KAMIKAZE_PACK.get());

                        pOutput.accept(ItemMod.KNIFE.get());
                        pOutput.accept(ItemMod.SHURIKEN_ITEM.get());
                        pOutput.accept(ItemMod.BUNGEE.get());
                        pOutput.accept(ItemMod.WIND_BOOST.get());

                        pOutput.accept(ItemMod.CREEPER_CHILD.get());
                        pOutput.accept(BlockMod.INSTA_TNT.get());
                        pOutput.accept(BlockMod.TRAP_TNT.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}