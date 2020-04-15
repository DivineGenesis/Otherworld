package com.divinegenesis.otherworld.common.world.gen;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.world.gen.features.HeartCrystalFeature;
import com.divinegenesis.otherworld.common.world.gen.features.UrnFeature;
import com.google.common.collect.Lists;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class OWFeatures
{
    private static List<Feature<?>> features = Lists.newArrayList();

    public static final Feature<NoFeatureConfig>
            CRYSTAL_HEART = register("heart_crystal", new HeartCrystalFeature(NoFeatureConfig::deserialize));
    public static final Feature<?> URNS = register("urns", new UrnFeature(NoFeatureConfig::deserialize));
            //GREATWOOD_TREE = register("greatwood_tree", );

    private static Feature register(String key, Feature feature)
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