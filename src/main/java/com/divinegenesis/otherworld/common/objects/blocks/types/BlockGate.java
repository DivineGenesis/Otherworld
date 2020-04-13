package com.divinegenesis.otherworld.common.objects.blocks.types;

import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import net.minecraft.block.FenceGateBlock;

public class BlockGate extends FenceGateBlock {
    public BlockGate(Properties properties, String name)
    {
        super(properties);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
    }
}
