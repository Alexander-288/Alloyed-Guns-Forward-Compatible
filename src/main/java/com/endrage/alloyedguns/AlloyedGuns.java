package com.endrage.alloyedguns;

import com.endrage.alloyedguns.client.ClientHandler;
import com.endrage.alloyedguns.init.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.core.registries.Registries;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(AlloyedGuns.MOD_ID)
public class AlloyedGuns
{
    public static final String MOD_ID = "alloyedguns";

    private static final ResourceKey<net.minecraft.world.item.CreativeModeTab> CGM_TAB =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath("cgm", "creative_tab"));

    public AlloyedGuns(IEventBus bus, ModContainer container)
    {
        ModItems.ITEMS.register(bus);
        bus.addListener(this::onAddPackFinders);
        bus.addListener(this::onBuildCreativeTab);
        if(FMLEnvironment.dist == Dist.CLIENT)
        {
            ClientHandler.init(bus);
        }
    }

    // Always-on packs that override CGM's own assets and data (reskins, stats, recipes)
    private void onAddPackFinders(AddPackFindersEvent event)
    {
        if(event.getPackType() == PackType.CLIENT_RESOURCES)
        {
            event.addPackFinders(id("resourcepacks/cgm_overrides"), PackType.CLIENT_RESOURCES,
                    Component.literal("Alloyed Guns: CGM reskin"), PackSource.BUILT_IN, true, Pack.Position.TOP);
        }
        else if(event.getPackType() == PackType.SERVER_DATA)
        {
            event.addPackFinders(id("datapacks/cgm_overrides"), PackType.SERVER_DATA,
                    Component.literal("Alloyed Guns: CGM changes"), PackSource.BUILT_IN, true, Pack.Position.TOP);
        }
    }

    // Our items go in CGM's creative tab, like on 1.19.2
    private void onBuildCreativeTab(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey().equals(CGM_TAB))
        {
            ModItems.ITEMS.getEntries().forEach(item -> event.accept(item.get()));
        }
    }

    public static ResourceLocation id(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
