package com.example.chowbattle.block;

import com.example.chowbattle.ChowBattleMod;
import com.example.chowbattle.item.ItemMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockMod
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ChowBattleMod.MODID);

    public static final RegistryObject<Block> INSTA_TNT = registerBlock("insta_tnt",
            () -> new InstaTNT(BlockBehaviour.Properties.copy(Blocks.TNT).noLootTable()));
    public static final RegistryObject<Block> TRAP_TNT = registerBlock("trap_tnt",
            () -> new TrapTNT(BlockBehaviour.Properties.copy(Blocks.TNT).noLootTable()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemMod.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
