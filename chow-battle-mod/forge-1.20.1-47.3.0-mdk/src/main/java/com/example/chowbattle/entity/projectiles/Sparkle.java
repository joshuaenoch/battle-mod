package com.example.chowbattle.entity.projectiles;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class Sparkle extends Snowball {

    public Sparkle(EntityType<? extends Snowball> entityType, Level level) {
        super(entityType, level);
        this.setNoGravity(true);
    }

    public Sparkle(Level level, LivingEntity owner) {
        super(level, owner);
        this.setNoGravity(true);
    }

    @Override
    protected void onHitEntity(EntityHitResult target) {
        super.onHitEntity(target);
        Entity targetEntity = target.getEntity();
        if(targetEntity instanceof LivingEntity){
            LivingEntity targetLivingEntity = (LivingEntity) targetEntity;
            targetLivingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 1));
        }
    }
}
