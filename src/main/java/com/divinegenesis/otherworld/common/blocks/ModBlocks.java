package com.divinegenesis.otherworld.common.blocks;

import com.divinegenesis.otherworld.common.blocks.types.BlockBase;
import com.divinegenesis.otherworld.common.blocks.types.BlockHungryChest;
import com.divinegenesis.otherworld.common.blocks.types.BlockPedestal;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final Block
        ICHORIUM_ORE = new BlockBase("ichorium_ore", Material.ROCK),
        URN = new BlockBase("urn", Material.ROCK),
        SILVERWOOD_LOG = new BlockBase("silverwood_log", Material.WOOD),
        SILVERWOOD_LEAVES = new BlockBase("silverwood_leaves", Material.LEAVES),
        SILVERWOOD_SAPLING = new BlockBase("silverwood_sapling", Material.PLANTS),
        GREATWOOD_LOG = new BlockBase("greatwood_log", Material.WOOD),
        GREATWOOD_PLANK = new BlockBase("greatwood_plank", Block.Properties.create(Material.WOOD).sound(SoundType.WOOD)),
        GREATWOOD_LEAVES = new BlockBase("greatwood_leaves", Material.LEAVES),
        GREATWOOD_SAPLING = new BlockBase("greatwood_sapling", Material.PLANTS),
        ARCANE_PEDESTAL = new BlockPedestal("arcane_pedestal", Material.ROCK),
        HUNGRY_CHEST = new BlockHungryChest("hungry_chest", Material.WOOD);
}