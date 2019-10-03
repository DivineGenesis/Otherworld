package com.divinegenesis.otherworld.common.item;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

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
