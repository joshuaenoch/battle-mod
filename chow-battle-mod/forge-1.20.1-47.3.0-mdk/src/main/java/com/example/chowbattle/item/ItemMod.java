package com.example.chowbattle.item;

import com.example.chowbattle.ChowBattleMod;
import com.example.chowbattle.entity.EntityMod;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemMod {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChowBattleMod.MODID);

    // packs
    public static final RegistryObject<Item> PACK = ITEMS.register("pack",
            () -> new Pack(new Item.Properties()));
    public static final RegistryObject<Item> NINJA_PACK = ITEMS.register("ninja_pack",
            () -> new NinjaPack(new Item.Properties()));
    public static final RegistryObject<Item> KAMIKAZE_PACK = ITEMS.register("kamikaze_pack",
            () -> new KamikazePack(new Item.Properties()));
    public static final RegistryObject<Item> GLADIATOR_PACK = ITEMS.register("gladiator_pack",
            () -> new GladiatorPack(new Item.Properties()));
    public static final RegistryObject<Item> SURVIVALIST_PACK = ITEMS.register("survivalist_pack",
            () -> new SurvivalistPack(new Item.Properties()));
    public static final RegistryObject<Item> SAM_PACK = ITEMS.register("special_pack",
            () -> new SamPack(new Item.Properties()));

    // ninja modded items
    public static final RegistryObject<Item> BUNGEE = ITEMS.register("bungee",
            () -> new Bungee(new Item.Properties()));
    public static final RegistryObject<Item> KNIFE = ITEMS.register("knife",
            () -> new Knife(Tiers.IRON, 2, 1.2F, new Item.Properties()));
    public static final RegistryObject<Item> WIND_BOOST = ITEMS.register("wind_boost",
            () -> new WindBoost(new Item.Properties()));
    public static final RegistryObject<Item> SHURIKEN_ITEM = ITEMS.register("shuriken_item",
            () -> new ShurikenItem(new Item.Properties()));

    // kamikaze modded item
    public static final RegistryObject<Item> CREEPER_CHILD = ITEMS.register("creeper_child",
            () -> new CreeperChild(new Item.Properties()));

    // princess modded item
    public static final RegistryObject<Item> PRINCESS_HORN = ITEMS.register("princess_horn",
            () -> new PrincessHorn(new Item.Properties()));
    public static final RegistryObject<Item> WAND = ITEMS.register("wand",
            () -> new Wand(new Item.Properties().durability(20)));

    // misc
    public static final RegistryObject<Item> NO_ITEM = ITEMS.register("no_item",
            () -> new NoItem(new Item.Properties()));
    public static final RegistryObject<Item> FAKE_AK = ITEMS.register("fake_ak",
            () -> new FakeAK(new Item.Properties().durability(500)));
    public static final RegistryObject<Item> SAM_EGG = ITEMS.register("sam_egg",
            () -> new SamSpawner(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}