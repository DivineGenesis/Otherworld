package com.divinegenesis.otherworld.common.objects.items.types;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemTaglock extends ItemBase {
    public ItemTaglock(String name) {
        super(name);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> list, ITooltipFlag flag)
    {
        if(isTagged(stack))
            list.add(new TranslationTextComponent("tooltip."+this.getRegistryName()).applyTextStyle(TextFormatting.GRAY).appendText(getTaggedUser(stack)));
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }

    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return isTagged(stack);
    }

    private static boolean isTagged(ItemStack stack)
    {
        CompoundNBT nbt = stack.getOrCreateTag();
        return !nbt.getString("tagged").isEmpty();
    }

    public static String getTaggedUser(ItemStack stack)
    {
        CompoundNBT nbt = stack.getOrCreateTag();
        if(!isTagged(stack)) return "";
        return  nbt.getString("tagged");
    }
}
