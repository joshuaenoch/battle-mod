package com.example.chowbattle.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.Map;

public class SamPack extends Pack{
    public SamPack(Properties properties) {
        super(properties);
    }

    @Override
    public void setInventory(Player player){
        player.getInventory().setItem(1, new ItemStack(ItemMod.NO_ITEM.get(), 64));
        player.getInventory().setItem(2, new ItemStack(ItemMod.NO_ITEM.get(), 64));
        player.getInventory().setItem(3, new ItemStack(ItemMod.NO_ITEM.get(), 64));
        player.getInventory().setItem(4, new ItemStack(ItemMod.NO_ITEM.get(), 64));
        player.getInventory().setItem(5, new ItemStack(ItemMod.NO_ITEM.get(), 64));
    }
}
