package com.divinegenesis.otherworld.common.objects.blocks.types;

import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import net.minecraft.block.FenceBlock;

public class BlockFence extends FenceBlock
{
    public BlockFence(Properties properties, String name)
    {
        super(properties);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
    }
}
