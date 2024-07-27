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
    public WindBoost(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        Vec3 lookVector = player.getViewVector(1.0F);
        Vec3 boostVector = lookVector.scale(2.0);
        player.setDeltaMovement(player.getDeltaMovement().add(boostVector));

        ItemStack itemStack = player.getItemInHand(interactionHand);
        return InteractionResultHolder.success(itemStack);
    }
}
