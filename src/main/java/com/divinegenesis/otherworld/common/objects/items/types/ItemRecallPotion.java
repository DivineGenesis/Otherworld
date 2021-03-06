package com.divinegenesis.otherworld.common.objects.items.types;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Optional;

public class ItemRecallPotion extends Item
{
    public ItemRecallPotion(Properties properties)
    {
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(!worldIn.isRemote() && entityLiving instanceof PlayerEntity)
        {
            PlayerEntity playerIn = (PlayerEntity) entityLiving;
            BlockPos pos = playerIn.getBedLocation(worldIn.getDimension().getType());
            Optional<Vec3d> vec = PlayerEntity.func_213822_a(worldIn, pos, true);
            if(vec.isPresent())
                pos = new BlockPos(vec.get().x, vec.get().y, vec.get().z);
            else
                pos = worldIn.getSpawnPoint();
            playerIn.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
        }
        return stack;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.setActiveHand(handIn);
        return new ActionResult<>(ActionResultType.CONSUME, playerIn.getHeldItem(handIn));
    }

    @Override
    public UseAction getUseAction(ItemStack stack)
    {
        return UseAction.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return  32;
    }

    @Override
    public boolean hasEffect(ItemStack p_77636_1_) {
        return true;
    }
}
