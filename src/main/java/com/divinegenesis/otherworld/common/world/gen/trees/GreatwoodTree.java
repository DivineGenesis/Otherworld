package com.divinegenesis.otherworld.common.world.gen.trees;

import net.minecraft.block.trees.BigTree;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class GreatwoodTree extends BigTree {

    @Nullable
    @Override
    protected ConfiguredFeature<HugeTreeFeatureConfig, ?> func_225547_a_(Random random) {
        return null;
    }

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> func_225546_b_(Random random, boolean b) {
        return null;
    }
}
