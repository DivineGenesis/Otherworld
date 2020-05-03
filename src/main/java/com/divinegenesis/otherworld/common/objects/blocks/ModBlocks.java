package com.divinegenesis.otherworld.common.objects.blocks;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.ModTileEntities;
import com.divinegenesis.otherworld.common.objects.blocks.types.*;
import com.divinegenesis.otherworld.common.world.gen.trees.GreatwoodTree;
import com.divinegenesis.otherworld.common.world.gen.trees.WitchwoodTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;

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
        WITCHWOOD_LOG = register("witchwood_log", new LogBlock(MaterialColor.WHITE_TERRACOTTA, Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD))),
        WITCHWOOD_PLANK = register("witchwood_plank", new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD))),
        WITCHWOOD_STAIRS = register("witchwood_stairs", new StairsBlock(() -> WITCHWOOD_PLANK.getDefaultState(), Block.Properties.from(WITCHWOOD_PLANK))),
        WITCHWOOD_FENCE = register("witchwood_fence", new FenceBlock(Block.Properties.from(WITCHWOOD_PLANK))),
        WITCHWOOD_SLAB = register("witchwood_slab", new SlabBlock(Block.Properties.from(WITCHWOOD_PLANK))),
        WITCHWOOD_GATE = register("witchwood_gate", new FenceGateBlock(Block.Properties.from(WITCHWOOD_PLANK))),
        WITCHWOOD_LEAVES = register("witchwood_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid())),
        WITCHWOOD_SAPLING = register("witchwood_sapling", new BlockSaplingOW(new WitchwoodTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT))),
        GREATWOOD_LOG = register("greatwood_log", new LogBlock(MaterialColor.BROWN ,Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD))),
        GREATWOOD_PLANK = register("greatwood_plank", new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD))),
        GREATWOOD_STAIRS = register("greatwood_stairs", new StairsBlock(() -> GREATWOOD_PLANK.getDefaultState(), Block.Properties.from(GREATWOOD_PLANK))),
        GREATWOOD_FENCE = register("greatwood_fence", new FenceBlock(Block.Properties.from(GREATWOOD_PLANK))),
        GREATWOOD_SLAB = register("greatwood_slab", new SlabBlock(Block.Properties.from(GREATWOOD_PLANK))),
        GREATWOOD_GATE = register("greatwood_gate", new FenceGateBlock(Block.Properties.from(GREATWOOD_PLANK))),
        //GREATWOOD_BUTTON = register("greatwood_button", new WoodButtonBlock(Block.Properties.from(GREATWOOD_PLANK))),
        GREATWOOD_LEAVES = register("greatwood_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid())),
        GREATWOOD_SAPLING = register("greatwood_sapling", new BlockSaplingOW(new GreatwoodTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT))),
        HUNGRY_CHEST = register("hungry_chest", new BlockHungryChest(Material.WOOD, () -> { return ModTileEntities.HUNGRY_CHEST; })),
        CRYSTAL_HEART = register("crystal_heart", new BlockCrystalHeart(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.STONE))),
        SOUL_FORGE = register("soul_forge", new BlockSoulForge(Block.Properties.create(Material.ROCK))),
        TRAVELLER_PAVEMENT = register("traveller_pavement", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.STONE))),
        MANDRAKE_CROP = register("mandrake", new BlockMandrakePlant(Block.Properties.create(Material.PLANTS)));

    private static Block register(String name, Block block)
    {
        block.setRegistryName(Otherworld.MODID, name);
        BLOCKS.add(block);
        return block;
    }
}