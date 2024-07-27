package com.example.chowbattle.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TrapTNT extends Block{
    public TrapTNT(Block.Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, Level.ExplosionInteraction.TNT);
    }
}
