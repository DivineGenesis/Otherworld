package com.divinegenesis.otherworld.common.blocks.tileentities;

import com.divinegenesis.otherworld.common.ModTileEntities;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class HungryChestTE extends ChestTileEntity implements ITickableTileEntity
{
    private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);

    public HungryChestTE() {
        super(ModTileEntities.HUNGRY_CHEST);
    }

    @Override
    public void tick()
    {
        if(!world.isRemote() && world.getGameTime() % 20 == 0)
        {
            handler.ifPresent(h ->
            {
                AxisAlignedBB loc = new AxisAlignedBB(pos.getX()-3, pos.getY()-3, pos.getZ()-3, pos.getX()+3, pos.getY()+3, pos.getZ()+3);
                if( world.getEntitiesWithinAABB(ItemEntity.class, loc).isEmpty())
                    return;

                world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 1f, 1f);
                //world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.BLOCKS, 1f, 1f, false);
                ItemEntity entity = world.getEntitiesWithinAABB(ItemEntity.class, loc).get(0);
                ItemStack i = entity.getItem();
                for(int x = 0; x < h.getSlots(); x++)
                {
                    entity.setItem(ItemStack.EMPTY);
                    i = h.insertItem(x, i, false);
                    if (i.isEmpty()) return;
                }
            });
        }
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

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side)
    {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return handler.cast();
        return super.getCapability(cap, side);
    }

    private IItemHandler createHandler()
    {
        return new ItemStackHandler(27)
        {
            @Override
            protected void onContentsChanged(int slot)
            {
                markDirty();
            }
        };
    }
}
