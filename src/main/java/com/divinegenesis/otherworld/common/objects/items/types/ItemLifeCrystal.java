package com.divinegenesis.otherworld.common.objects.items.types;

import com.divinegenesis.otherworld.common.ModSounds;
import com.divinegenesis.otherworld.common.helpers.HealthHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemLifeCrystal extends Item {

    public ItemLifeCrystal(Properties properties) {
        super(properties);
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        return new StringTextComponent(TextFormatting.RED + super.getDisplayName(stack).getString());
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

            if(!HealthHelper.isMaxHealth(playerIn, HealthHelper.HealthType.LIFE_CRYSTAL))
            {
                HealthHelper.giveHealth(playerIn, HealthHelper.HealthType.LIFE_CRYSTAL);
                playerIn.playSound(ModSounds.CRYSTAL_HEART, 1f, 1f);
                playerIn.getHeldItem(handIn).setCount(playerIn.getHeldItem(handIn).getCount()-1);
            }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
