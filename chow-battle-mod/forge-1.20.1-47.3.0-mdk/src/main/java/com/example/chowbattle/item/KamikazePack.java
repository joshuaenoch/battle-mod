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

public class KamikazePack extends Pack{
    public KamikazePack(Properties properties) {
        super(properties);
    }

    @Override
    public void setInventory(Player player){
        player.getInventory().setItem(0, new ItemStack(ItemMod.CREEPER_CHILD.get(), 10));
        player.getInventory().setItem(1, new ItemStack(BlockMod.INSTA_TNT.get(), 3));
        player.getInventory().setItem(2, new ItemStack(BlockMod.TRAP_TNT.get(), 10));
        player.getInventory().setItem(3, new ItemStack(Items.TNT, 10));
        player.getInventory().setItem(4, new ItemStack(Items.FLINT_AND_STEEL));
        player.getInventory().setItem(5, new ItemStack(Items.FISHING_ROD));
        player.getInventory().setItem(6, new ItemStack(Items.ROTTEN_FLESH, 16));
        ItemStack speedPotion = new ItemStack(Items.POTION);
        PotionUtils.setPotion(speedPotion, Potions.SWIFTNESS);
        player.getInventory().setItem(7, speedPotion);

        ItemStack enchantedChestPlate = new ItemStack(Items.IRON_CHESTPLATE, 1);
        EnchantmentHelper.setEnchantments(Map.of(
            Enchantments.BLAST_PROTECTION, 5,
            Enchantments.UNBREAKING, 5
            ), enchantedChestPlate);
        player.getInventory().armor.set(2, enchantedChestPlate);
        ItemStack enchantedLeggings = new ItemStack(Items.IRON_LEGGINGS, 1);
        EnchantmentHelper.setEnchantments(Map.of(
            Enchantments.BLAST_PROTECTION, 5,
            Enchantments.UNBREAKING, 5
            ), enchantedLeggings);
        player.getInventory().armor.set(1, enchantedLeggings);
    }
}
