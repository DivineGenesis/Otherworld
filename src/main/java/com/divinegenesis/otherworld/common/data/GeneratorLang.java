package com.divinegenesis.otherworld.common.data;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.objects.entities.ModEntities;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import static com.divinegenesis.otherworld.common.objects.items.ModItems.*;
import static com.divinegenesis.otherworld.common.objects.enchants.ModEnchants.*;

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
        add(MANDRAKE_ROOT, "Mandrake Root");
        add("item.otherworld.ichor_bucket", "Ichorium Bucket");
        add(TAGLOCK, "Taglock");
        add(BONE_NEEDLE, "Bone Needle");
        add(SOUL_OF_FLIGHT,"Soul of Flight");

        //blocks
        add(ModBlocks.ICHORIUM_ORE, "Ichorium Ore");
        add(ModBlocks.URN, "Urn");
        add(ModBlocks.CRYSTAL_HEART, "Crystal Heart");
        add(ModBlocks.HUNGRY_CHEST, "Hungry Chest");
        add(ModBlocks.GREATWOOD_PLANK, "Greatwood Plank");
        add(ModBlocks.SOUL_FORGE, "Soul Forge");

        //add(ModEntities.MANDRAKE, "Mandrake");

        //fluid
        add("fluid.otherworld.ichor_fluid", "Ichorium Essence");


        //enchants
        add(SOULBOUND, "Soulbound");
        add(LIFE_STEAL, "Life Steal");
        add(BEHEADING, "Beheading");
        add(REPAIR, "Repair");
        add(AUTO_SMELT, "Auto-Smelt");
        add(AUTO_PICKUP, "Auto-Pickup");
        add(REAPING, "Reaping");

        //advancements
        add("advancementTab.otherworld", "Otherworld");
        add("advancementTab.otherworld.desc", "Thanks for playing our mod :)");

        //tooltips
        add(tooltip(HEART), "This shiny item resembles a heart and probably not edible, wonder what it tastes like");
        add(tooltip(MAGIC_MIRROR), "Mirror mirror in my hand, take me from this far-away land");
        add(tooltip(RECALL_POTION), "Returns user to bed or overworld spawn");
        add(tooltip(UMBRELLA), "\"Im Mary Poppins yall!\"");
        add(tooltip(TAGLOCK), "Bound to: ");
        add(tooltip(SOUL_OF_FLIGHT), "The essence of powerful flying creatures");
    }

    private String tooltip(Item item) { return "tooltip." + item.getRegistryName(); }
    private String curios(String identifier) { return "curios.identifier." + identifier; }
}