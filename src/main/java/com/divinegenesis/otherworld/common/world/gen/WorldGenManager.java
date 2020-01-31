package com.divinegenesis.otherworld.common.world.gen;

import com.divinegenesis.otherworld.common.blocks.ModBlocks;
import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenManager
{

    public static void setupGenerator()
    {
        ForgeRegistries.BIOMES.forEach(biome ->
        {
           // biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, crystalHeartFeature());
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, urnFeature());
        });
    }


    private static ConfiguredFeature<?, ?> crystalHeartFeature()
    {
        return OWFeature.CRYSTAL_HEART.
                withConfiguration(new NoFeatureConfig())
                .func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(5, 5, 8, 21)));
    }

    private static ConfiguredFeature<?, ?> urnFeature()
    {
        return Feature.DISK.withConfiguration(
                new SphereReplaceConfig(
                        ModBlocks.URN.getDefaultState(),
                        3,
                        2,
                        Lists.newArrayList(Blocks.AIR.getDefaultState()))
        ).func_227228_a_(
                Placement.CARVING_MASK.func_227446_a_(
                        new CaveEdgeConfig(
                                GenerationStage.Carving.AIR,
                                100f
                        )));
    }
}
