package com.example.chowbattle.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class Bungee extends Item {
    private static final int COOLDOWN_TIME = 100;

    public Bungee(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (!player.getCooldowns().isOnCooldown(this)) {
            player.setDeltaMovement(0, 1.2, 0);
            player.getCooldowns().addCooldown(this, COOLDOWN_TIME);
            return InteractionResultHolder.success(itemStack);

        } else {
            return InteractionResultHolder.fail(itemStack);
        }
    }
}
