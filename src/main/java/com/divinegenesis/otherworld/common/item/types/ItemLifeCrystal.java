package com.divinegenesis.otherworld.common.item.types;

import com.divinegenesis.otherworld.common.helpers.HealthHelper;
import com.divinegenesis.otherworld.common.item.types.ItemBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemLifeCrystal extends ItemBase {

    public ItemLifeCrystal(String name) {
        super(name);
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        return new StringTextComponent(TextFormatting.RED + super.getDisplayName(stack).getString());
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        if(!worldIn.isRemote())
        {
            if(!HealthHelper.isMaxHealth(playerIn, HealthHelper.HealthType.LIFE_CRYSTAL))
            {
                HealthHelper.giveHealth(playerIn, HealthHelper.HealthType.LIFE_CRYSTAL);
                playerIn.getHeldItem(handIn).setCount(playerIn.getHeldItem(handIn).getCount()-1);
            }
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
