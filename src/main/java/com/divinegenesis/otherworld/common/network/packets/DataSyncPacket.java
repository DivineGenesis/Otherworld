package com.divinegenesis.otherworld.common.network.packets;

import com.divinegenesis.otherworld.common.capability.CapabilityOWPlayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class DataSyncPacket
{
    private final boolean soul;

    public DataSyncPacket(boolean soul)
    {
        this.soul = soul;
    }

    public static void encode(DataSyncPacket msg, PacketBuffer packetBuffer)
    {
        packetBuffer.writeBoolean(msg.soul);
    }

    public static DataSyncPacket decode(PacketBuffer packetBuffer)
    {
        return new DataSyncPacket(packetBuffer.readBoolean());
    }

    public static void handle(DataSyncPacket msg, Supplier<NetworkEvent.Context> ctx)
    {
        ctx.get().enqueueWork(() -> {
            PlayerEntity playerEntity = ctx.get().getSender();

            playerEntity.getCapability(CapabilityOWPlayer.DATA).ifPresent(iowPlayerStorage -> iowPlayerStorage.setSoul(msg.soul));
        });

        ctx.get().setPacketHandled(true);
    }
}