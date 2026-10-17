package com.endrage.alloyedguns.client;

import com.endrage.alloyedguns.init.ModItems;
import com.mrcrayfish.guns.client.GunItemStackRenderer;
import com.mrcrayfish.guns.client.render.gun.ModelOverrides;
import com.mrcrayfish.guns.client.render.gun.model.SimpleModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

public class ClientHandler
{
    public static void init(IEventBus bus)
    {
        bus.addListener(ClientHandler::onClientSetup);
        bus.addListener(ClientHandler::onRegisterClientExtensions);
        bus.addListener(SpecialModels::registerAdditional);
        bus.addListener(ModelEvent.BakingCompleted.class, SpecialModels::onBake);
    }

    private static void onClientSetup(FMLClientSetupEvent event)
    {
        event.enqueueWork(() -> {
            ModelOverrides.register(ModItems.FLINTLOCK.get(), new SimpleModel(SpecialModels.FLINTLOCK::getModel));
            ModelOverrides.register(ModItems.MUSKET.get(), new SimpleModel(SpecialModels.MUSKET::getModel));
        });
    }

    // Use CGM's gun renderer for our guns
    private static void onRegisterClientExtensions(RegisterClientExtensionsEvent event)
    {
        IClientItemExtensions extensions = new IClientItemExtensions()
        {
            private final GunItemStackRenderer renderer = new GunItemStackRenderer();

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer()
            {
                return this.renderer;
            }
        };
        event.registerItem(extensions, ModItems.FLINTLOCK.get(), ModItems.MUSKET.get());
    }
}
