package com.divinegenesis.otherworld.common.events;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.capability.CapabilityOWPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class AttachCapEvent
{
    @SubscribeEvent
    public static void capAttach(AttachCapabilitiesEvent<Entity> event)
    {
        if(event.getObject() instanceof PlayerEntity)
        {
            event.addCapability(new ResourceLocation(Otherworld.MODID), new CapabilityOWPlayer.Provider());
        }
    }
}