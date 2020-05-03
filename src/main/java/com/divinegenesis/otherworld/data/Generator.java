package com.divinegenesis.otherworld.data;


import com.divinegenesis.otherworld.Otherworld;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Otherworld.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Generator
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();

        if(event.includeServer())
        {
            gen.addProvider(new GeneratorLoot(gen));
            gen.addProvider(new GeneratorRecipes(gen));
        }

        if(event.includeClient())
        {
            ExistingFileHelper helper = event.getExistingFileHelper();

            gen.addProvider(new GeneratorBlockstates(gen, helper));
            gen.addProvider(new GeneratorItemModels(gen, helper));
            gen.addProvider(new GeneratorLang(gen));
        }
    }
}