package com.divinegenesis.otherworld.common.world.gen;

import com.divinegenesis.otherworld.common.blocks.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenManager
{
    public static void setupGenerator()
    {
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            ChanceRangeConfig crystal_heart = new ChanceRangeConfig(5, 0, 0, 16);

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.CRYSTAL_HEART.getDefaultState(), 5)).func_227228_a_( Placement.CHANCE_RANGE.func_227446_a_(crystal_heart)));
        }
    }
}
