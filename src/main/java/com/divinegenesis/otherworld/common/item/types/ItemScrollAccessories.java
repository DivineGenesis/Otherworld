package com.divinegenesis.otherworld.common.item.types;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import top.theillusivec4.curios.api.CuriosAPI;

public class ItemScrollAccessories extends ItemBase {
    public ItemScrollAccessories(String name) {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        if(CuriosAPI.getSlotsForType(playerIn, "accessories") < 6)
        {
            CuriosAPI.addTypeSlotsToEntity("accessories", 1, playerIn);
            playerIn.setHeldItem(handIn, ItemStack.EMPTY);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
