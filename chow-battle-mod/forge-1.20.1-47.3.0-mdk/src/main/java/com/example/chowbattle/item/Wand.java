package com.example.chowbattle.item;

import com.example.chowbattle.entity.projectiles.Sparkle;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Wand extends Item {

    public Wand(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.AMETHYST_BLOCK_STEP, SoundSource.PLAYERS, 1.0F, 1.0F);

        Sparkle sparkle = new Sparkle(level, player);
        sparkle.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3F, 1.0F);
        level.addFreshEntity(sparkle);

        //return
        ItemStack itemStack = player.getItemInHand(interactionHand);
        itemStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(interactionHand));
        return InteractionResultHolder.success(itemStack);
    }
}
