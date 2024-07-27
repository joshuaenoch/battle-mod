package com.example.chowbattle.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Pack extends Item {
    public Pack(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            player.getInventory().setItem(i, ItemStack.EMPTY);
        }
        for (int i = 0; i < player.getInventory().armor.size(); i++) {
            player.getInventory().armor.set(i, ItemStack.EMPTY);
        }

        player.removeAllEffects();

        setInventory(player);

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    public void setInventory(Player player){
    }
}
