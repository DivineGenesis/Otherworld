package com.divinegenesis.otherworld.common.events;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.capability.CapabilityOWPlayer;
import com.divinegenesis.otherworld.common.network.NetworkHandler;
import com.divinegenesis.otherworld.common.network.packets.DataSyncPacket;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;

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

    @SubscribeEvent
    public static void onLogin(PlayerEvent.PlayerLoggedInEvent event)
    {
        PlayerEntity playerEntity = event.getPlayer();
        playerEntity.getCapability(CapabilityOWPlayer.DATA).ifPresent(iowPlayerStorage ->
        {
            if(playerEntity instanceof ServerPlayerEntity)
            {
                NetworkHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerEntity),
                        new DataSyncPacket(iowPlayerStorage.hasSoul()));
            }
        });
    }

    @SubscribeEvent
    public static void onClone(PlayerEvent.Clone event)
    {
        PlayerEntity old = event.getOriginal();
        PlayerEntity player = event.getPlayer();

        old.getCapability(CapabilityOWPlayer.DATA).ifPresent(oldData ->
                player.getCapability(CapabilityOWPlayer.DATA).ifPresent(newData -> {
                    newData.setSoul(oldData.hasSoul());

                    NetworkHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player),
                            new DataSyncPacket(newData.hasSoul()));
                }));

    }
}