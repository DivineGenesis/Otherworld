package com.divinegenesis.otherworld.common.blocks.types;

import com.divinegenesis.otherworld.common.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block
{
    public BlockBase(String name, Material material)
    {
        super(Block.Properties.create(material));
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
    }

    public BlockBase(String name, Properties properties)
    {
        super(properties);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
    }


    public BlockBase()
    {
        super(Block.Properties.create(Material.BAMBOO));
    }

}
