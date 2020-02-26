package com.divinegenesis.otherworld.common.objects.items.types;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.objects.items.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBase extends Item
{
    private boolean hasTooltip = true;

    public ItemBase(String name)
    {
        super(new Properties().group(Otherworld.OWTAB));
        setRegistryName(name);
        ModItems.ITEMS.add(this);
    }
    public ItemBase(String name, boolean hasTooltip)
    {
        super(new Properties().group(Otherworld.OWTAB));
        setRegistryName(name);
        hasTooltip = hasTooltip;
        ModItems.ITEMS.add(this);
    }

    public ItemBase(String name, Properties properties)
    {
        super(properties.group(Otherworld.OWTAB));
        setRegistryName(name);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> list, ITooltipFlag flag)
    {
        list.add(new TranslationTextComponent("tooltip."+this.getRegistryName()).applyTextStyle(TextFormatting.GRAY));
        super.addInformation(stack, world, list, flag);
    }
}
