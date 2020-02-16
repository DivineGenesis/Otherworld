package com.divinegenesis.otherworld.common.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.NBTTypes;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CapabilityOWPlayer
{
    @CapabilityInject(IOWPlayerStorage.class)
    public static Capability<IOWPlayerStorage> DATA = null;

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IOWPlayerStorage.class, new Capability.IStorage<IOWPlayerStorage>()
        {
            @Nullable
            @Override
            public INBT writeNBT(Capability<IOWPlayerStorage> capability, IOWPlayerStorage instance, Direction side)
            {
                CompoundNBT compoundNBT = new CompoundNBT();
                compoundNBT.putBoolean("has_soul", instance.hasSoul());
                return compoundNBT;
            }

            @Override
            public void readNBT(Capability<IOWPlayerStorage> capability, IOWPlayerStorage instance, Direction side, INBT nbt)
            {
                ((OWPlayerStorage) instance).soul = ((CompoundNBT)nbt).getBoolean("has_soul");
            }
        }, OWPlayerStorage::new);
    }

    public static class Provider implements ICapabilityProvider
    {
        final LazyOptional<IOWPlayerStorage> capability;

        public Provider()
        {
            this.capability = LazyOptional.of(OWPlayerStorage::new);
        }

        @Nonnull
        @Override
        public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
            return CapabilityOWPlayer.DATA.orEmpty(cap, capability);
        }
    }
}
