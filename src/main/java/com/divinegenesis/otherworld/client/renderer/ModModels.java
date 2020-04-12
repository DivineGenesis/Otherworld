package com.divinegenesis.otherworld.client.renderer;

import com.divinegenesis.otherworld.Otherworld;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;

@Mod.EventBusSubscriber(modid = Otherworld.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModModels
{
    public enum locations
    {
        HUNGRY_CHEST("hungry_chest");

        locations(String name)
        {
            location = new ResourceLocation(Otherworld.MODID, "models/"+name);
        }

        private ResourceLocation location;

        public ResourceLocation getLocation() {
            return location;
        }
    }

    @SubscribeEvent
    public static void onStitch(TextureStitchEvent.Pre event) {
        if (!event.getMap().getBasePath().equals(Atlases.CHEST_ATLAS))
            return;


        for (locations value : locations.values()) {
            event.addSprite(value.getLocation());

        }
    }
}
