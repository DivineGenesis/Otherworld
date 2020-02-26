package com.divinegenesis.otherworld.common.objects.items.types;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Optional;

public class ItemMagicMirror extends ItemBase
{
    public ItemMagicMirror(String name)
    {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        if(!worldIn.isRemote())
        {
            BlockPos pos = playerIn.getBedLocation(worldIn.getDimension().getType());
            Optional<Vec3d> vec = PlayerEntity.func_213822_a(worldIn, pos, false);
            if(vec.isPresent())
                pos = new BlockPos(vec.get().x, vec.get().y, vec.get().z);
            else
                pos = worldIn.getSpawnPoint();
            playerIn.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());//setPosition(pos.getX(), pos.getY(), pos.getZ());
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}