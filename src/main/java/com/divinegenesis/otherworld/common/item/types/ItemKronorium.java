package com.divinegenesis.otherworld.common.item.types;

import com.divinegenesis.otherworld.common.item.types.ItemBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class ItemKronorium extends ItemBase
{
    public ItemKronorium()
    {
        super("kronorium");
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        return new StringTextComponent(TextFormatting.GOLD + super.getDisplayName(stack).getString());
    }
}
