package com.example.chowbattle.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CreeperChild extends Item{
    public CreeperChild(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        Creeper creeper = EntityType.CREEPER.create(level);
        creeper.startRiding(player);
        level.addFreshEntity(creeper);

        ItemStack itemStack = player.getItemInHand(hand);
        itemStack.shrink(1);
        player.setItemInHand(hand, itemStack);

        if (itemStack.isEmpty() && !player.getAbilities().instabuild) {
            return InteractionResultHolder.success(ItemStack.EMPTY);
        } else {
            return InteractionResultHolder.success(itemStack);
        }
    }
}
