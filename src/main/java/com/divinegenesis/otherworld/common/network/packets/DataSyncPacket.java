package com.divinegenesis.otherworld.common.network.packets;

import com.divinegenesis.otherworld.common.capability.OWPlayerCap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class DataSyncPacket
{

    private CompoundNBT nbt;

    public DataSyncPacket(){}

    public static void encode(DataSyncPacket msg, PacketBuffer buffer)
    {
        buffer.writeCompoundTag(msg.nbt);
    }

    public static DataSyncPacket decode(PacketBuffer buffer)
    {
        DataSyncPacket newpkt = new DataSyncPacket();

        newpkt.nbt = buffer.readCompoundTag();

        return newpkt;
    }

    public static void handle(DataSyncPacket msg, Supplier<NetworkEvent.Context> ctx)
    {
        ctx.get().enqueueWork(() ->
        {
            try {
                final PlayerEntity playerEntity = ctx.get().getSender();

                if (playerEntity != null)
                {
                    playerEntity.getCapability(OWPlayerCap.DATA).orElse(new OWPlayerCap.DefaultImp()).loadFromNBT(msg.nbt);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });

        ctx.get().setPacketHandled(true);
    }
}