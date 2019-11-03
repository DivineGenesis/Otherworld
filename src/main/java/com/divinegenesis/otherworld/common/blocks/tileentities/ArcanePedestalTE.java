package com.divinegenesis.otherworld.common.blocks.tileentities;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ArcanePedestalTE extends TileEntity
{
    private ItemStack itemStack = ItemStack.EMPTY;

    public ArcanePedestalTE(TileEntityType<?> tileEntityTypeIn)
    {
        super(tileEntityTypeIn);
    }

    @Override
    public void read(CompoundNBT compound)
    {
        super.read(compound);
        itemStack.deserializeNBT(compound);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound)
    {
        compound.put("inv", itemStack.serializeNBT());
        return super.write(compound);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side)
    {
        //if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
           // return (T) itemStack;
        return super.getCapability(cap, side);
    }
}
