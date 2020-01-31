package com.divinegenesis.otherworld.common.world.dimensions;

import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.NoiseChunkGenerator;

public class PurgatoryChunkGenerator extends NoiseChunkGenerator<PurgatoryGenSettings>
{
    public PurgatoryChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, int p_i49931_3_, int p_i49931_4_, int p_i49931_5_, PurgatoryGenSettings p_i49931_6_, boolean usePerlin) {
        super(worldIn, biomeProviderIn, p_i49931_3_, p_i49931_4_, p_i49931_5_, p_i49931_6_, usePerlin);
    }

    @Override
    protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ) {
        return new double[0];
    }

    @Override
    protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
        return 0;
    }

    @Override
    protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {

    }

    @Override
    public int getGroundHeight() {
        return 0;
    }
}
