package com.divinegenesis.otherworld.client.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class HealthRenderEvent {
    public static void render(RenderGameOverlayEvent event)
    {
        Entity e = Minecraft.getInstance().getRenderViewEntity();

        if(event.getType() != RenderGameOverlayEvent.ElementType.HEALTH || !(e instanceof PlayerEntity))
            return;

        PlayerEntity player = (PlayerEntity) e;

    }
}
