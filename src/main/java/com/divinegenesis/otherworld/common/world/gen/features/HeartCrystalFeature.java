package com.divinegenesis.otherworld.common.world.gen.features;

import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class HeartCrystalFeature extends Feature<NoFeatureConfig>
{
    public HeartCrystalFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config)
    {
        if(worldIn.getBlockState(pos).getBlock() == Blocks.CAVE_AIR)
        {
            if(worldIn.getBlockState(pos.down()).getBlock().isSolid(worldIn.getBlockState(pos.down())))
            {
                worldIn.setBlockState(pos, ModBlocks.CRYSTAL_HEART.getDefaultState(), 2);
                return true;
            }
        }
        return false;
    }
}
