package com.divinegenesis.otherworld.common.capability;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.capability.base.BaseProvider;
import com.divinegenesis.otherworld.common.capability.base.BaseStorage;
import com.divinegenesis.otherworld.common.capability.base.ICommonCap;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Base64;
import java.util.Random;

@Mod.EventBusSubscriber
public class OWWorldCap
{
    public static ResourceLocation RESOURCE = new ResourceLocation(Otherworld.MODID, "world_data");

    @CapabilityInject(IWorldData.class)
    public static Capability<IWorldData> DATA = null;

    public interface IWorldData extends ICommonCap
    {
        WorldEvilType getWorldEvil();
    }

    @Mod.EventBusSubscriber
    public static class EventHandler
    {
        @SubscribeEvent
        public static void onWorldConstruct(AttachCapabilitiesEvent<World> event)
        {
            event.addCapability(RESOURCE, new Provider(event.getObject().getRandom()));
        }
    }

    public static class Provider extends BaseProvider<IWorldData> {

        Random random;

        public Provider(Random random)
        {
            this.random = random;
        }

        @Override
        public IWorldData defaultImp() {
            return new DefaultImp(random);
        }

        @Override
        public Capability<IWorldData> dataInstance() {
            return DATA;
        }
    }

    public static class DefaultImp implements IWorldData {

        WorldEvilType evilType;

        public DefaultImp(){}

        public DefaultImp(Random r)
        {
            evilType = WorldEvilType.values()[r.nextInt(WorldEvilType.values().length)];
        }

        @Override
        public WorldEvilType getWorldEvil() {
            return evilType;
        }

        @Override
        public CompoundNBT saveToNBT() {
            CompoundNBT nbt = new CompoundNBT();
            nbt.putString("world_evil", evilType.name());
            return nbt;
        }

        @Override
        public void loadFromNBT(CompoundNBT value)
        {
            evilType = WorldEvilType.valueOf(value.getString("world_evil"));
        }
    }

    enum WorldEvilType {CORRUPTION, CRIMSON, HALLOW };

    public static class Storage extends BaseStorage<IWorldData>
    {

    }
}
