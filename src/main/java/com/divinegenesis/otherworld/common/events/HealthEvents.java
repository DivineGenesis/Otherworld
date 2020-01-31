package com.divinegenesis.otherworld.common.events;

import com.divinegenesis.otherworld.common.helpers.HealthHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HealthEvents
{
    @SubscribeEvent
    public static void OnRespawn(PlayerEvent.Clone event)
    {
        PlayerEntity player = event.getPlayer();
        PlayerEntity old = event.getOriginal();

        HealthHelper.giveBackMyAttributes(old, player);
    }
}
