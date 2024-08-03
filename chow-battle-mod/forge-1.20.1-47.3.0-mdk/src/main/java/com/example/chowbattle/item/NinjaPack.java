package com.example.chowbattle.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.Map;

public class NinjaPack extends Pack{
    public NinjaPack(Properties properties) {
        super(properties);
    }

    @Override
    public void setInventory(Player player){
        player.getInventory().setItem(0, new ItemStack(ItemMod.KNIFE.get()));
        player.getInventory().setItem(1, new ItemStack(ItemMod.SHURIKEN_ITEM.get(), 32));
        player.getInventory().setItem(2, new ItemStack(ItemMod.BUNGEE.get()));
        player.getInventory().setItem(3, new ItemStack(ItemMod.WIND_BOOST.get()));
        player.getInventory().setItem(4, new ItemStack(Items.COOKED_COD, 16));
        ItemStack invisibilityPotion = new ItemStack(Items.POTION);
        PotionUtils.setPotion(invisibilityPotion, Potions.INVISIBILITY);
        player.getInventory().setItem(5, invisibilityPotion);

        ItemStack enchantedBoots = new ItemStack(Items.LEATHER_BOOTS, 1);
        EnchantmentHelper.setEnchantments(Map.of(
            Enchantments.FALL_PROTECTION, 10,
            Enchantments.UNBREAKING, 10,
            Enchantments.ALL_DAMAGE_PROTECTION, 4
            ), enchantedBoots);
        player.getInventory().armor.set(0, enchantedBoots);
    }
}
