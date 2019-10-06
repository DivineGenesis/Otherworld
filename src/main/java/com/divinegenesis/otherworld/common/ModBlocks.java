package com.divinegenesis.otherworld.common;

import com.divinegenesis.otherworld.common.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block
        ICHORIUM = new BlockBase("ichorium_ore", Material.ROCK);
}