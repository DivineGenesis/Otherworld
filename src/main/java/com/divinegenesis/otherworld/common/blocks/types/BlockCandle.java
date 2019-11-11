package com.divinegenesis.otherworld.common.blocks.types;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BlockCandle extends BlockBase
{
    public BlockCandle(String name, Properties properties)
    {
        super(name, properties);
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items)
    {
        super.fillItemGroup(group, items);
    }

}