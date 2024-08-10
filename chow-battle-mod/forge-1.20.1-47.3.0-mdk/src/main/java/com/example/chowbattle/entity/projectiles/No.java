package com.example.chowbattle.entity.projectiles;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class No extends Snowball {

    public No(EntityType<? extends Snowball> entityType, Level level) {
        super(entityType, level);
    }

    public No(Level level, LivingEntity owner) {
        super(level, owner);
    }

    @Override
    protected void onHitEntity(EntityHitResult target) {
        super.onHitEntity(target);
        Entity targetEntity = target.getEntity();
        targetEntity.kill();
    }
}
