package com.endrage.alloyedguns.init;

import com.endrage.alloyedguns.AlloyedGuns;
import com.mrcrayfish.guns.item.AmmoItem;
import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AlloyedGuns.MOD_ID);

    // Guns
    public static final DeferredItem<GunItem> MUSKET = ITEMS.register("musket", () -> new GunItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<GunItem> FLINTLOCK = ITEMS.register("flintlock", () -> new GunItem(new Item.Properties().stacksTo(1)));

    // Guns from the Create Guns pack, rendered from their plain item models
    public static final DeferredItem<GunItem> CAPLOCK_PISTOL = ITEMS.register("caplock_pistol", () -> new GunItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<GunItem> MULES_LEG = ITEMS.register("mules_leg", () -> new GunItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<GunItem> SAWED_OFF = ITEMS.register("sawed_off", () -> new GunItem(new Item.Properties().stacksTo(1)));

    // Unfinished guns
    public static final DeferredItem<AmmoItem> UNFINISHED_ASSAULT_RIFLE = ammo("unfinished_assault_rifle", 1);
    public static final DeferredItem<AmmoItem> UNFINISHED_FLINTLOCK = ammo("unfinished_flintlock", 1);
    public static final DeferredItem<AmmoItem> UNFINISHED_GRENADE_LAUNCHER = ammo("unfinished_grenade_launcher", 1);
    public static final DeferredItem<AmmoItem> UNFINISHED_MACHINE_PISTOL = ammo("unfinished_machine_pistol", 1);
    public static final DeferredItem<AmmoItem> UNFINISHED_MUSKET = ammo("unfinished_musket", 1);
    public static final DeferredItem<AmmoItem> UNFINISHED_PISTOL = ammo("unfinished_pistol", 1);
    public static final DeferredItem<AmmoItem> UNFINISHED_RIFLE = ammo("unfinished_rifle", 1);
    public static final DeferredItem<AmmoItem> UNFINISHED_SHOTGUN = ammo("unfinished_shotgun", 1);

    // Ammo and parts
    public static final DeferredItem<AmmoItem> CRUDE_SHOT = ammo("crude_shot", 16);
    public static final DeferredItem<AmmoItem> COMPLEX_BULLET = ammo("complex_bullet", 16);
    public static final DeferredItem<AmmoItem> INCOMPLETE_COMPLEX_BULLET = ammo("incomplete_complex_bullet", 16);
    public static final DeferredItem<AmmoItem> BASIC_BULLET_CASING = ammo("basic_bullet_casing", 64);
    public static final DeferredItem<AmmoItem> ADVANCED_BULLET_CASING = ammo("advanced_bullet_casing", 64);
    public static final DeferredItem<AmmoItem> EMPTY_SHELL = ammo("empty_shell", 64);
    public static final DeferredItem<AmmoItem> COMPLEX_BULLET_CASING = ammo("complex_bullet_casing", 16);
    public static final DeferredItem<AmmoItem> COMPRESSED_AIR_CANISTER = ammo("compressed_air_canister", 64);
    public static final DeferredItem<AmmoItem> UNARMED_MISSILE = ammo("unarmed_missile", 64);
    public static final DeferredItem<AmmoItem> GUNPOWDER_BOTTLE = ammo("gunpowder_bottle", 64);
    public static final DeferredItem<AmmoItem> REVOLVER_CYLINDER = ammo("revolver_cylinder", 1);
    public static final DeferredItem<AmmoItem> MAGAZINE = ammo("magazine", 1);
    public static final DeferredItem<Item> SMALL_STEEL_PIPE = ITEMS.registerSimpleItem("small_steel_pipe");
    public static final DeferredItem<Item> SMALL_IRON_PIPE = ITEMS.registerSimpleItem("small_iron_pipe");

    // Gun kits
    public static final DeferredItem<AmmoItem> CRUDE_GUN_KIT = ammo("crude_gun_kit", 1);
    public static final DeferredItem<AmmoItem> BASIC_GUN_KIT = ammo("basic_gun_kit", 1);
    public static final DeferredItem<AmmoItem> ADVANCED_GUN_KIT = ammo("advanced_gun_kit", 1);
    public static final DeferredItem<AmmoItem> COMPLEX_GUN_KIT = ammo("complex_gun_kit", 1);

    // Sequenced assembly in-between items
    public static final DeferredItem<AmmoItem> INCOMPLETE_BASIC_BULLET = ammo("incomplete_basic_bullet", 64);
    public static final DeferredItem<AmmoItem> INCOMPLETE_ADVANCED_BULLET = ammo("incomplete_advanced_bullet", 64);
    public static final DeferredItem<AmmoItem> INCOMPLETE_SHELL = ammo("incomplete_shell", 64);
    public static final DeferredItem<AmmoItem> HARMLESS_GRENADE = ammo("harmless_grenade", 64);

    private static DeferredItem<AmmoItem> ammo(String name, int stackSize)
    {
        return ITEMS.register(name, () -> new AmmoItem(new Item.Properties().stacksTo(stackSize)));
    }
}
