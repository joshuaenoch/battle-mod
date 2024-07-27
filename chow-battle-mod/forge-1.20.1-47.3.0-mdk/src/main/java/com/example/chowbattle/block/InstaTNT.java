package com.example.chowbattle.block;

import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class InstaTNT extends Block {
    public InstaTNT(Block.Properties properties) {
        super(properties);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, Level.ExplosionInteraction.TNT);
    }
}
