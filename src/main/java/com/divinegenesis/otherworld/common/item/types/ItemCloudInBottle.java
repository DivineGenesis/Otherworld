package com.divinegenesis.otherworld.common.item.types;

import com.divinegenesis.otherworld.common.item.types.ItemBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class ItemCloudInBottle extends ItemBase
{

    public ItemCloudInBottle(String name) {
        super(name);
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        return new StringTextComponent(TextFormatting.AQUA + super.getDisplayName(stack).getString());
    }
}
