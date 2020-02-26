package com.divinegenesis.otherworld.common.objects.items.types;

import com.divinegenesis.otherworld.common.helpers.HealthHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemLifeFruit extends ItemBase {
    public ItemLifeFruit(String name) {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        if(!worldIn.isRemote())
        {
            if(HealthHelper.isMaxHealth(playerIn, HealthHelper.HealthType.LIFE_CRYSTAL)
                    && !HealthHelper.isMaxHealth(playerIn, HealthHelper.HealthType.LIFE_FRUIT))
            {
                HealthHelper.giveHealth(playerIn, HealthHelper.HealthType.LIFE_FRUIT);
                playerIn.getHeldItem(handIn).setCount(playerIn.getHeldItem(handIn).getCount()-1);
            }
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}