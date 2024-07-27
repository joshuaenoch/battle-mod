package com.example.chowbattle.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Bungee extends Item {
    public Bungee(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        player.setDeltaMovement(0, 1, 0);

        ItemStack itemStack = player.getItemInHand(interactionHand);
        return InteractionResultHolder.success(itemStack);
    }
}
