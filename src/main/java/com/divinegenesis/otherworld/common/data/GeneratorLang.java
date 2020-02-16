package com.divinegenesis.otherworld.common.data;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import static com.divinegenesis.otherworld.common.item.ModItems.*;
import static com.divinegenesis.otherworld.common.enchants.ModEnchants.*;

public class GeneratorLang extends LanguageProvider
{
    public GeneratorLang(DataGenerator gen)
    {
        super(gen, Otherworld.MODID, "en_us");
    }

    @Override
    protected void addTranslations()
    {
        add("itemGroup.otherworld", "Otherworld");

        //curios
        add(curios("accessories"), "Accessories");

        //items
        add(HEART, "Life Crystal");
        add(LIFE_FRUIT, "Life Fruit");
        add(MAGIC_MIRROR, "Magical Mirror");
        add(RECALL_POTION,"Recall Potion");
        add(ENDER_POUCH, "Enderpouch");
        add("item.otherworld.ichor_bucket", "Ichorium Bucket");

        //blocks
        add(ModBlocks.ICHORIUM_ORE, "Ichorium Ore");
        add(ModBlocks.URN, "Urn");
        add(ModBlocks.HUNGRY_CHEST, "Hungry Chest");
        add(ModBlocks.GREATWOOD_PLANK, "Greatwood Plank");

        //fluid
        add("fluid.otherworld.ichor_fluid", "Ichorium Essence");


        //enchants
        add(SOULBOUND, "Soulbound");
        add(LIFE_STEAL, "Life Steal");
        add(BEHEADING, "Beheading");
        add(REPAIR, "Repair");
        add(AUTO_SMELT, "Auto-Smelt");
        add(AUTO_PICKUP, "Auto-Pickup");

        //advancements
        add("advancementTab.otherworld", "Otherworld");
        add("advancementTab.otherworld.desc", "Thanks for playing our mod :)");

        //tooltips
        add(tooltip(HEART), "This shiny item resembles a heart and probably not edible, wonder what it tastes like");
        add(tooltip(MAGIC_MIRROR), "Mirror mirror in my hand, take me from this far-away land");
        add(tooltip(RECALL_POTION), "Returns user to bed or overworld spawn");
        add(tooltip(UMBRELLA), "\"Im Mary Poppins yall!\"");
    }

    private String tooltip(Item item) { return "tooltip." + item.getRegistryName(); }
    private String curios(String identifier) { return "curios.identifier." + identifier; }
}
