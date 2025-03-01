package com.example.chowbattle.entity;

import com.example.chowbattle.ChowBattleMod;
import com.example.chowbattle.entity.projectiles.No;
import com.example.chowbattle.entity.projectiles.Shuriken;
import com.example.chowbattle.entity.projectiles.Sparkle;
import com.example.chowbattle.entity.sam.SamuelEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityMod
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ChowBattleMod.MODID);

    public static final RegistryObject<EntityType<Shuriken>> SHURIKEN =
            ENTITY_TYPES.register("shuriken", () -> EntityType.Builder.<Shuriken>of(Shuriken::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("shuriken"));

    public static final RegistryObject<EntityType<No>> NO =
            ENTITY_TYPES.register("no", () -> EntityType.Builder.<No>of(No::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("no"));

    public static final RegistryObject<EntityType<Sparkle>> SPARKLE =
            ENTITY_TYPES.register("sparkle", () -> EntityType.Builder.<Sparkle>of(Sparkle::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("sparkle"));

    public static final RegistryObject<EntityType<SamuelEntity>> SAMUEL =
            ENTITY_TYPES.register("samuel", () -> EntityType.Builder.of(SamuelEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1f).build("samuel"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
