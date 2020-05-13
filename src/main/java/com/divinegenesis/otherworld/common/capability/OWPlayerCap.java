package com.divinegenesis.otherworld.common.capability;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.capability.base.BaseProvider;
import com.divinegenesis.otherworld.common.capability.base.BaseStorage;
import com.divinegenesis.otherworld.common.capability.base.ICommonCap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class OWPlayerCap
{
    public static ResourceLocation RESOURCE = new ResourceLocation(Otherworld.MODID, "playerdata");

    @CapabilityInject(IPlayerData.class)
    public static Capability<IPlayerData> DATA = null;

    public interface IPlayerData extends ICommonCap
    {
        boolean hasSoul();
        int sanity();
    }

    @Mod.EventBusSubscriber
    public static class EventHandler
    {
        @SubscribeEvent
        public static void onEntityConstruct(AttachCapabilitiesEvent<Entity> event)
        {
            if(event.getObject() instanceof PlayerEntity)
            {
                event.addCapability(OWPlayerCap.RESOURCE, new OWPlayerCap.Provider());
            }
        }
    }

    public static class Provider extends BaseProvider<IPlayerData>
    {

        @Override
        public IPlayerData defaultImp() {
            return new DefaultImp();
        }

        @Override
        public Capability<IPlayerData> dataInstance() {
            return DATA;
        }
    }

    public static class DefaultImp implements IPlayerData
    {
        boolean soul;
        int sanity;

        public DefaultImp()
        {
            soul = true;
            sanity = 250;
        }

        @Override
        public boolean hasSoul()
        {
            return soul;
        }

        @Override
        public int sanity() {
            return sanity;
        }

        @Override
        public CompoundNBT saveToNBT() {
            CompoundNBT nbt = new CompoundNBT();
            nbt.putBoolean("soul", hasSoul());
            nbt.putInt("sanity", sanity());
            return nbt;
        }

        @Override
        public void loadFromNBT(CompoundNBT value) {
            soul = value.getBoolean("soul");
            sanity = value.getInt("sanity");
        }
    }

    public static class Storage extends BaseStorage<IPlayerData>{}
}