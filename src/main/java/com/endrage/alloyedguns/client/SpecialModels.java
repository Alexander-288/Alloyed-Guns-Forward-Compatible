package com.endrage.alloyedguns.client;

import com.endrage.alloyedguns.AlloyedGuns;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.neoforged.neoforge.client.event.ModelEvent;

public enum SpecialModels
{
    FLINTLOCK("gun/flintlock"),
    MUSKET("gun/musket");

    private final ModelResourceLocation modelLocation;
    private BakedModel cachedModel;

    SpecialModels(String path)
    {
        this.modelLocation = ModelResourceLocation.standalone(AlloyedGuns.id("special/" + path));
    }

    public BakedModel getModel()
    {
        if(this.cachedModel == null)
        {
            this.cachedModel = Minecraft.getInstance().getModelManager().getModel(this.modelLocation);
        }
        return this.cachedModel;
    }

    public static void registerAdditional(ModelEvent.RegisterAdditional event)
    {
        for(SpecialModels model : values())
        {
            event.register(model.modelLocation);
        }
    }

    // Drop cached models after a resource reload
    public static void onBake(ModelEvent.BakingCompleted event)
    {
        for(SpecialModels model : values())
        {
            model.cachedModel = null;
        }
    }
}
