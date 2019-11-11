package com.divinegenesis.otherworld.common.blocks.tileentities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ArcanePedestalTE extends TileEntity
{
    private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);

    public ArcanePedestalTE(TileEntityType<?> tileEntityTypeIn)
    {
        super(tileEntityTypeIn);
    }

    @Override
    public void read(CompoundNBT compound)
    {
        CompoundNBT inv = compound.getCompound("inv");
        handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>)h).deserializeNBT(inv));

        super.read(compound);

    }

    @Override
    public CompoundNBT write(CompoundNBT compound)
    {
        handler.ifPresent( h ->
        {
            CompoundNBT nbt = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
            compound.put("inv", nbt);
        });
        return super.write(compound);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side)
    {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return handler.cast();
        return super.getCapability(cap, side);
    }

    private IItemHandler createHandler()
    {
        return new ItemStackHandler(1)
        {
            @Override
            protected void onContentsChanged(int slot)
            {
                markDirty();
            }
        };
    }
}
