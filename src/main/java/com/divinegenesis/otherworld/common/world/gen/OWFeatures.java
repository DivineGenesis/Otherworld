package com.divinegenesis.otherworld.common.world.gen;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.world.gen.features.HeartCrystalFeature;
import com.divinegenesis.otherworld.common.world.gen.features.UrnFeature;
import com.google.common.collect.Lists;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.List;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class OWFeatures
{
    private static List<Feature<?>> features = Lists.newArrayList();

    public static final Feature<NoFeatureConfig> CRYSTAL_HEART = registerFeature("heart_crystal", new HeartCrystalFeature(NoFeatureConfig::deserialize));
    public static final Feature<NoFeatureConfig> URNS = registerFeature("urns", new UrnFeature(NoFeatureConfig::deserialize));

    private static Feature registerFeature(String key, Feature feature)
    {
        feature.setRegistryName(Otherworld.MODID, key);
        features.add(feature);
        return feature;
    }

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event)
    {
        features.forEach(feature -> event.getRegistry().register(feature));
    }
}