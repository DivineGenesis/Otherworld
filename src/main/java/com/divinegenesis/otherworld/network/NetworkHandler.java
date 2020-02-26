package com.divinegenesis.otherworld.network;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.network.packets.DataSyncPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class NetworkHandler
{
    public static SimpleChannel INSTANCE;
    public static final String PROTOCOL_ID = "1";
    private static int id = 0;

    public static void register()
    {
        INSTANCE = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(Otherworld.MODID, "main"))
                .clientAcceptedVersions(PROTOCOL_ID::equals)
                .serverAcceptedVersions(PROTOCOL_ID::equals)
                .networkProtocolVersion(() -> PROTOCOL_ID)
                .simpleChannel();

        register(DataSyncPacket.class, DataSyncPacket::encode, DataSyncPacket::decode, DataSyncPacket::handle);
    }

    private static <M> void register(Class<M> messageType, BiConsumer<M, PacketBuffer> encoder,
                                     Function<PacketBuffer, M> decoder,
                                     BiConsumer<M, Supplier<NetworkEvent.Context>> messageConsumer) {

        INSTANCE.registerMessage(id++, messageType, encoder, decoder, messageConsumer);
    }
}
