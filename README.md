# Alloyed Guns (1.21.1 NeoForge)

Create-themed guns, ammo and crafting for MrCrayfish's Gun Mod, ported to Minecraft 1.21.1 on NeoForge.

This is a port of End_Rage's Alloyed Guns 1.1.0 (1.19.2). It is an addon: it adds the flintlock and musket, gun kits, casings and unfinished guns, and changes CGM's guns, stats and recipes to be made with Create.

## Requirements

- NeoForge 21.1.259 or newer
- CGM-Unofficial 1.4.21 (NeoForge 1.21.1 port of MrCrayfish's Gun Mod)
- Framework 0.13.11 or newer (needed by CGM)
- Create 6.0 or newer
- Any mod that provides steel through the common tags `c:ingots/steel`, `c:nuggets/steel` and `c:plates/steel` (for example Alloyed, but any steel mod works). Without one, the steel recipes can't be crafted.

## What changed from 1.19.2

- No longer depends on Alloyed. Steel is matched by common `c:` tags.
- Smithing recipes (flintlock, musket and their unfinished parts) are now shapeless crafting recipes, because 1.21 smithing needs a template item.
- Gun kits in chest loot are added with loot modifiers instead of replacing the vanilla chest tables.
- The CGM reskin and CGM recipe/stat changes ship as built-in packs that are always on.

## Building

1. Put `CGM-Unofficial-1.4.21+NeoForge+1.21.1.jar` in the `libs` folder.
2. Run `./gradlew build`. The jar ends up in `build/libs`.

`./gradlew runClient` starts a test game with CGM, Create and Alloyed.

## Credits

Original mod and models by End_Rage. MrCrayfish's Gun Mod by MrCrayfish. Licensed under GPL-3.0.
