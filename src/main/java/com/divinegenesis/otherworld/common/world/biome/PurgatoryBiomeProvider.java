package com.divinegenesis.otherworld.common.world.biome;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.feature.structure.Structure;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

public class PurgatoryBiomeProvider extends BiomeProvider {






    @Override
    public Biome getBiome(int i, int i1) {
        return null;
    }

    @Override
    public Biome[] getBiomes(int i, int i1, int i2, int i3, boolean b) {
        return new Biome[0];
    }

    @Override
    public Set<Biome> getBiomesInSquare(int i, int i1, int i2) {
        return null;
    }

    @Nullable
    @Override
    public BlockPos findBiomePosition(int i, int i1, int i2, List<Biome> list, Random random) {
        return null;
    }

    @Override
    public boolean hasStructure(Structure<?> structure) {
        return false;
    }

    @Override
    public Set<BlockState> getSurfaceBlocks() {
        return null;
    }
}
