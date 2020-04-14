package com.divinegenesis.otherworld.common.objects.blocks;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.ModTileEntities;
import com.divinegenesis.otherworld.common.objects.blocks.types.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Supplier;

public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block
        ICHORIUM_ORE = register("ichorium_ore", new Block(Block.Properties.create(Material.ROCK))),
        URN = register("urn", new BlockUrn(Block.Properties.create(Material.GLASS))),
        WITCHWOOD_LOG = register("witchwood_log", new LogBlock(MaterialColor.WHITE_TERRACOTTA, Block.Properties.create(Material.WOOD))),
        WITCHWOOD_PLANK = register("witchwood_plank", new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD))),
        WITCHWOOD_STAIRS = register("witchwood_stairs", new StairsBlock(() -> WITCHWOOD_PLANK.getDefaultState(), Block.Properties.from(WITCHWOOD_PLANK))),
        WITCHWOOD_FENCE = register("witchwood_fence", new FenceBlock(Block.Properties.from(WITCHWOOD_PLANK))),
        WITCHWOOD_SLAB = register("witchwood_slab", new SlabBlock(Block.Properties.from(WITCHWOOD_PLANK))),
        WITCHWOOD_GATE = register("witchwood_gate", new FenceGateBlock(Block.Properties.from(WITCHWOOD_PLANK))),
        SILVERWOOD_LEAVES = register("witchwood_leaves", new Block(Block.Properties.create(Material.LEAVES))),
        SILVERWOOD_SAPLING = register("witchwood_sapling", new Block(Block.Properties.create(Material.PLANTS))),
        GREATWOOD_LOG = register("greatwood_log", new LogBlock(MaterialColor.BROWN ,Block.Properties.create(Material.WOOD))),
        GREATWOOD_PLANK = register("greatwood_plank", new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD))),
        GREATWOOD_STAIRS = register("greatwood_stairs", new StairsBlock(() -> GREATWOOD_PLANK.getDefaultState(), Block.Properties.from(GREATWOOD_PLANK))),
        GREATWOOD_FENCE = register("greatwood_fence", new FenceBlock(Block.Properties.from(GREATWOOD_PLANK))),
        GREATWOOD_SLAB = register("greatwood_slab", new SlabBlock(Block.Properties.from(GREATWOOD_PLANK))),
        GREATWOOD_GATE = register("greatwood_gate", new FenceGateBlock(Block.Properties.from(GREATWOOD_PLANK))),
        GREATWOOD_LEAVES = register("greatwood_leaves", new Block(Block.Properties.create(Material.LEAVES))),
        GREATWOOD_SAPLING = register("greatwood_sapling", new Block(Block.Properties.create(Material.PLANTS))),
        HUNGRY_CHEST = register("hungry_chest", new BlockHungryChest(Material.WOOD, () -> { return ModTileEntities.HUNGRY_CHEST; })),
        CRYSTAL_HEART = register("crystal_heart", new BlockCrystalHeart(Block.Properties.create(Material.ROCK))),
        SOUL_FORGE = register("soul_forge", new BlockSoulForge(Block.Properties.create(Material.ROCK))),
        MANDRAKE_CROP = register("mandrake_crop", new BlockMandrakePlant(Block.Properties.create(Material.PLANTS)));

    private static Block register(String name, Block block)
    {
        block.setRegistryName(Otherworld.MODID, name);
        BLOCKS.add(block);
        return block;
    }
}