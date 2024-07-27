package com.example.chowbattle.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PrincessHorn extends Item {
    public PrincessHorn(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        level.playSound(player, player.getOnPos(), SoundEvents.GOAT_HORN_PLAY, SoundSource.RECORDS);
        Wolf wolf = EntityType.WOLF.create(level);
        Wolf wolf2 = EntityType.WOLF.create(level);
        level.addFreshEntity(wolf);
        level.addFreshEntity(wolf2);

        ItemStack itemStack = player.getItemInHand(hand);
        return InteractionResultHolder.success(itemStack);
    }
}
