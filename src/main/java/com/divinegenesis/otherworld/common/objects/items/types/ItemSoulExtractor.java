package com.divinegenesis.otherworld.common.objects.items.types;

import com.divinegenesis.otherworld.common.capability.CapabilityOWPlayer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemSoulExtractor extends ItemBase {
    public ItemSoulExtractor(String name) {
        super(name);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity)
        {
            PlayerEntity playerIn = (PlayerEntity) entityLiving;
            playerIn.getCapability(CapabilityOWPlayer.DATA)
                    .ifPresent(iowPlayerStorage -> iowPlayerStorage.setSoul(!iowPlayerStorage.hasSoul()));
        }
        return ItemStack.EMPTY;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.setActiveHand(handIn);
        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
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
}
