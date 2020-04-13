package com.divinegenesis.otherworld.common.objects.items.types;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.objects.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;

public class BlockItemBase extends BlockNamedItem {
    public BlockItemBase(Block block, String name)
    {
        super(block, new Properties().group(Otherworld.OWTAB));
        setRegistryName(name);
        ModItems.ITEMS.add(this);
    }
}
