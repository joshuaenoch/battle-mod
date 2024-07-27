package com.example.chowbattle.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class Shuriken extends Snowball {

    public Shuriken(EntityType<? extends Snowball> entityType, Level level) {
        super(entityType, level);
    }

    public Shuriken(Level level, LivingEntity owner) {
        super(level, owner);
    }

    @Override
    protected void onHitEntity(EntityHitResult target) {
        super.onHitEntity(target);
        Entity targetEntity = target.getEntity();
        targetEntity.hurt(this.damageSources().thrown(this, this.getOwner()), 4f);
    }
}
