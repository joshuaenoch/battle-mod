package com.example.chowbattle.entity.sam;

import com.example.chowbattle.TabMod;
import com.example.chowbattle.item.ItemMod;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class SamuelEntity extends Monster {

    public SamuelEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(0, new FloatGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, false));
        this.targetSelector.addGoal(3, new MeleeAttackGoal(this, 0.8f, false));
        this.goalSelector.addGoal(7, new SamRangedGoal(this, 24));
        this.targetSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 150D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, .6D)
                .add(Attributes.ATTACK_KNOCKBACK, 2f)
                .add(Attributes.ATTACK_DAMAGE, 2f);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() { return null;}

    public void startSeenByPlayer(ServerPlayer p_31483_) {
        super.startSeenByPlayer(p_31483_);
        this.bossEvent.addPlayer (p_31483_);
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        super.stopSeenByPlayer(p_31488_);
        this.bossEvent.removePlayer(p_31488_);
    }

    public boolean hurt(DamageSource p_34288_, float p_34289_) {
        super.hurt(p_34288_, p_34289_);
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        return true;
    }

    /*@Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
                                        MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData,
                                        @Nullable CompoundTag compoundTag) {
        // Set the item in the main hand
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemMod.FAKE_AK.get()));
        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }*/

    public class SamRangedGoal extends Goal {
        private final SamuelEntity sam;
        private final double range; // range within which the mob will start shooting
        private LivingEntity target;

        public SamRangedGoal(SamuelEntity sam, double range) {
            this.sam = sam;
            this.range = range;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.sam.getTarget();
            if (target == null) {
                return false;
            }
            double distanceToTarget = this.sam.distanceTo(target);
            return distanceToTarget <= this.range;
        }

        @Override
        public void start() {
            this.target = this.sam.getTarget();
        }

        @Override
        public void tick() {
            if (this.target == null) {
                return;
            }

            double distanceToTarget = this.sam.distanceTo(this.target);

            // Turn to face the target
            this.sam.getLookControl().setLookAt(this.target);

            if (distanceToTarget <= this.range) {
                // Shoot an arrow
                shootArrow();
            }
        }

        private void shootArrow() {
            if (!this.sam.isSilent()) {
                this.sam.level().playSound(null, this.sam.getX(), this.sam.getY(), this.sam.getZ(),
                        SoundEvents.FIREWORK_ROCKET_BLAST, SoundSource.NEUTRAL, 1.0F, 1.0F);
            }
            Arrow arrow = new Arrow(this.sam.level(), this.sam);
            Vec3 look = this.sam.getLookAngle();
            arrow.setPos(this.sam.getX() + look.x * 1.5, this.sam.getY() + this.sam.getEyeHeight() - 0.10000000149011612D,
                    this.sam.getZ() + look.z * 1.5);
            arrow.shoot(look.x, look.y, look.z, 1.6F, 0.0F); // Adjust the speed and spread as needed
            this.sam.level().addFreshEntity(arrow);
        }
    }

}