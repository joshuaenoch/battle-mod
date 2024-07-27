package com.example.chowbattle.item;

import com.example.chowbattle.block.BlockMod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.Map;

public class GladiatorPack extends Pack{
    public GladiatorPack(Properties properties) {
        super(properties);
    }

    @Override
    public void setInventory(Player player){
        player.getInventory().setItem(0, new ItemStack(Items.IRON_SWORD));
        player.getInventory().setItem(1, new ItemStack(Items.IRON_AXE));
        player.getInventory().setItem(2, new ItemStack(Items.BOW));
        player.getInventory().setItem(3, new ItemStack(Items.ARROW, 32));
        player.getInventory().setItem(4, new ItemStack(Items.COOKED_BEEF, 16));
        player.getInventory().setItem(5, new ItemStack(Items.SHIELD));

        player.getInventory().armor.set(3, new ItemStack(Items.DIAMOND_HELMET, 1));
        player.getInventory().armor.set(2, new ItemStack(Items.IRON_CHESTPLATE, 1));
        player.getInventory().armor.set(1, new ItemStack(Items.IRON_LEGGINGS, 1));
        player.getInventory().armor.set(0, new ItemStack(Items.GOLDEN_BOOTS, 1));
    }
}
