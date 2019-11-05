package com.divinegenesis.otherworld.common.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Generator
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        gen.addProvider(new GeneratorRecipes(gen));
        gen.addProvider(new GeneratorLang(gen));
        //gen.addProvider(new GeneratorLoot(gen));

        gen.addProvider(new GeneratorItemModels(gen, helper));
        gen.addProvider(new GeneratorAdvancements(gen));
        //gen.addProvider(new GeneratorTags(gen, ));
            gen.addProvider(new GeneratorBlockstates(gen, helper));
    }
}