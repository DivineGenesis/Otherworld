package com.divinegenesis.otherworld.common.item.types;

import com.divinegenesis.otherworld.Otherworld;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWand extends ItemBase
{
    public ItemWand(String name) {
        super(name);
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        return new StringTextComponent(getCap(stack).name()+" Capped "+getCore(stack).name()+" Wand").applyTextStyle(TextFormatting.YELLOW);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> list, ITooltipFlag flag)
    {
        if(!Screen.hasShiftDown())
        {
            list.add(new TranslationTextComponent("otherworld.tooltip.showinfo"));
        }
        else
        {

        }
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items)
    {
        if(group == Otherworld.OWTAB)
        {
            ItemStack base = new ItemStack(this);
            setCap(CapTypes.Iron, base);
            setCore(CoreTypes.Wooden, base);
            items.add(base);
        }
    }

    public static enum Components { Cap, Core }
    public static enum CoreTypes { Wooden, Ichor}
    public static enum CapTypes { Iron, Gold, Ichor}

    public static void setCore(CoreTypes type, ItemStack stack)
    {
        stack.getOrCreateTag().putString(Components.Core.name(), type.name());
    }

    public static CoreTypes getCore(ItemStack stack) {
        if (!stack.hasTag() || !stack.getTag().contains(Components.Core.name()))
            stack.getOrCreateTag().putString(Components.Core.name(), CoreTypes.Wooden.name());
        return CoreTypes.valueOf(stack.getTag().getString(Components.Core.name()));
    }

    public static void setCap(CapTypes type, ItemStack stack)
    {
        stack.getOrCreateTag().putString(Components.Cap.name(), type.name());
    }

    public static CapTypes getCap(ItemStack stack) {
        if (!stack.hasTag() || !stack.getTag().contains(Components.Cap.name()))
            stack.getOrCreateTag().putString(Components.Cap.name(), CapTypes.Iron.name());
        return CapTypes.valueOf(stack.getTag().getString(Components.Cap.name()));
    }

}
