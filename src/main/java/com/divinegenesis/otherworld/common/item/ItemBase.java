package com.divinegenesis.otherworld.common.item;

import com.divinegenesis.otherworld.OWGroup;
import com.divinegenesis.otherworld.common.ModItems;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
    public ItemBase(String name)
    {
        super(new Properties().group(OWGroup.GROUP));
        setRegistryName(name);
        ModItems.ITEMS.add(this);
    }
}
