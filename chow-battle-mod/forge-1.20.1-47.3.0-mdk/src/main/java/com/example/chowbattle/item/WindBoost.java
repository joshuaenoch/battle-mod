package com.example.chowbattle.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class WindBoost extends Item {
    private static final int COOLDOWN_TIME = 100;
    public WindBoost(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (!player.getCooldowns().isOnCooldown(this)) {
            Vec3 lookVector = player.getViewVector(1.0F);
            Vec3 boostVector = lookVector.scale(2.0);
            player.setDeltaMovement(player.getDeltaMovement().add(boostVector));

            player.getCooldowns().addCooldown(this, COOLDOWN_TIME);
            return InteractionResultHolder.success(itemStack);

        } else {
            return InteractionResultHolder.fail(itemStack);
        }
    }
}
