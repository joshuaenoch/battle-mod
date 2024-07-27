package com.example.chowbattle.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class SurvivalistPack extends Pack{
    public SurvivalistPack(Properties properties) {
        super(properties);
    }

    @Override
    public void setInventory(Player player) {
        player.getInventory().setItem(0, new ItemStack(Items.BOW));
        player.getInventory().setItem(1, new ItemStack(Items.ARROW, 64));
        player.getInventory().setItem(2, new ItemStack(Items.DIRT, 32));
        player.getInventory().setItem(3, new ItemStack(Items.COBWEB, 32));
        player.getInventory().setItem(4, new ItemStack(Items.APPLE, 32));
        player.getInventory().setItem(5, new ItemStack(Items.LAVA_BUCKET));
        player.getInventory().setItem(6, new ItemStack(Items.LAVA_BUCKET));

        player.getInventory().armor.set(3, new ItemStack(Items.CHAINMAIL_HELMET, 1));
        player.getInventory().armor.set(2, new ItemStack(Items.CHAINMAIL_CHESTPLATE, 1));
    }
}
