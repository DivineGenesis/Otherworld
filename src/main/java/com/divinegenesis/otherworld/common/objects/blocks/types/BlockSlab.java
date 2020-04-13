package com.divinegenesis.otherworld.common.objects.blocks.types;

import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import net.minecraft.block.SlabBlock;

public class BlockSlab extends SlabBlock {
    public BlockSlab(Properties properties, String name)
    {
        super(properties);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
    }
}
