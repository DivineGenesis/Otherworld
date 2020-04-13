package com.divinegenesis.otherworld.common.objects.blocks.types;

import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class BlockStairs extends StairsBlock {
    public BlockStairs(BlockState state, Properties properties, String name)
    {
        super(state, properties);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
    }
}
