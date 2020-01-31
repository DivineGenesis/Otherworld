package com.divinegenesis.otherworld.common.world.gen;

import com.divinegenesis.otherworld.common.world.gen.features.HeartCrystalFeature;
import com.divinegenesis.otherworld.common.world.gen.features.UrnFeature;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class OWFeature extends ForgeRegistryEntry<Feature<?>>
{
    public static final Feature<NoFeatureConfig> CRYSTAL_HEART = register("heart_crystal", new HeartCrystalFeature(NoFeatureConfig::deserialize));
    public static final Feature<NoFeatureConfig> URNS = register("urns", new UrnFeature(NoFeatureConfig::deserialize));

    private static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F value) {
        return (F)(Registry.<Feature<?>>register(Registry.FEATURE, key, value));
    }
}