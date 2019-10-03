package com.divinegenesis.otherworld.common.block;

import com.divinegenesis.otherworld.common.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.material.Material;

public class BlockBase extends Block
{
    public BlockBase(String name, Material material)
    {
        super(Block.Properties.create(material));
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);

    }

}
