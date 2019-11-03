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
        add(CLOUD_IN_BOTTLE, "Cloud in a Bottle");
        add(ENDER_POUCH, "Enderpouch");
        add(KRONORIUM, "Kronorium");
        add("item.otherworld.ichor_bucket", "Ichorium Bucket");

        //blocks
        add(ModBlocks.HUNGRY_CHEST, "Hungry Chest");

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
        add("advancement.otherworld:kronorium", "Kronorium Acquired");
        add("advancement.otherworld:kronorium.desc", "Great, like I wanted to know THAT exists...");

        //tooltips
        add(tooltip(HEART), "This shiny item resembles a heart and probably not edible, wonder what it tastes like");
    }

    private String tooltip(Item item) { return "tooltip." + item.getRegistryName(); }
    private String curios(String identifier) { return "curios.identifier." + identifier; }
}
