package com.divinegenesis.otherworld.common.objects.blocks;

import com.divinegenesis.otherworld.common.objects.blocks.tileentities.ModTileEntities;
import com.divinegenesis.otherworld.common.objects.blocks.types.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final Block
        ICHORIUM_ORE = new BlockBase("ichorium_ore", Material.ROCK),
        URN = new BlockUrn("urn", Material.GLASS),
        SILVERWOOD_LOG = new BlockBase("silverwood_log", Material.WOOD),
        SILVERWOOD_LEAVES = new BlockBase("silverwood_leaves", Material.LEAVES),
        SILVERWOOD_SAPLING = new BlockBase("silverwood_sapling", Material.PLANTS),
        GREATWOOD_LOG = new BlockBase("greatwood_log", Material.WOOD),
        GREATWOOD_PLANK = new BlockBase("greatwood_plank", Block.Properties.create(Material.WOOD).sound(SoundType.WOOD)),
        GREATWOOD_STAIRS = new BlockStairs(GREATWOOD_PLANK.getDefaultState(), Block.Properties.from(GREATWOOD_PLANK), "greatwood_stairs"),
        GREATWOOD_FENCE = new BlockFence(Block.Properties.from(GREATWOOD_PLANK), "greatwood_fence"),
        GREATWOOD_SLAB = new BlockSlab(Block.Properties.from(GREATWOOD_PLANK), "greatwood_slab"),
        GREATWOOD_GATE = new BlockGate(Block.Properties.from(GREATWOOD_PLANK), "greatwood_gate"),
        GREATWOOD_LEAVES = new BlockBase("greatwood_leaves", Material.LEAVES),
        GREATWOOD_SAPLING = new BlockBase("greatwood_sapling", Material.PLANTS),
        HUNGRY_CHEST = new BlockHungryChest("hungry_chest", Material.WOOD, () -> {return ModTileEntities.HUNGRY_CHEST; }),
        CRYSTAL_HEART = new BlockCrystalHeart("crystal_heart", Material.ROCK),
        RACK = new BlockRack(),
        SOUL_FORGE = new BlockSoulForge("soul_forge", Material.ROCK),
        MANDRAKE_CROP = new BlockMandrakePlant(Block.Properties.create(Material.PLANTS));
}