package com.example.chowbattle.item;

import com.example.chowbattle.entity.projectiles.Shuriken;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ShurikenItem extends Item {
    public ShurikenItem(Item.Properties p_43140_) {
        super(p_43140_);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            Shuriken shuriken = new Shuriken(level, player);
            shuriken.setItem(itemstack);
            shuriken.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3F, 1.0F);
            level.addFreshEntity(shuriken);
        }

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
