package com.divinegenesis.otherworld.common.objects.blocks.tileentities.types;

import com.divinegenesis.otherworld.common.objects.blocks.tileentities.ModTileEntities;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
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

import java.util.List;

public class HungryChestTE extends TileEntity implements ITickableTileEntity
{
    private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
    private int range = 3;

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
                AxisAlignedBB aoe = new AxisAlignedBB(
                        pos.getX()-range,
                        pos.getY()-range,
                        pos.getZ()-range,
                        pos.getX()+range,
                        pos.getY()+range,
                        pos.getZ()+range);
                List<ItemEntity> list = world.getEntitiesWithinAABB(ItemEntity.class, aoe);

                //if no items are in range
                if( list.isEmpty() )
                    return;

                //finds next item that can be stored
                for(ItemEntity e : list)
                {
                    ItemStack stack = e.getItem();
                    for(int i = 0; i < h.getSlots(); i++)
                    {
                        //if item can be put into slot
                        ItemStack returnStack = h.insertItem(i, stack, true);
                        if(returnStack.getCount() != stack.getCount())
                        {
                            e.setItem(h.insertItem(i, stack, false));

                            System.out.println(h.getSlots() + " " +!returnStack.isEmpty() + " " +i);

                            //if the fullstack went in
                            if(returnStack.isEmpty())
                            {
                                world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 1f, 1f);
                                return;
                            }

                            //if has returnstack AND last slot then burp..
                            if(!returnStack.isEmpty() && i == h.getSlots()-1)
                            {
                                world.playSound(null, pos, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.BLOCKS, 1f, 1f);
                                return;
                            }
                        }
                    }
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
