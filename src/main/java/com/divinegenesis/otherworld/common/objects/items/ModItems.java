package com.divinegenesis.otherworld.common.objects.items;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.objects.items.types.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.List;

public class ModItems
{
    public static final List<Item> ITEMS = new ArrayList<Item>();
    private static Item.Properties BASE = new Item.Properties().group(Otherworld.OWTAB);

    public static final Item
        ENDER_POUCH = register("ender_pouch", new ItemEnderPouch(BASE)),
        TOTEM_SOULBOUND = register("totem_soulbound", new Item(BASE)),
        MAGIC_MIRROR = register("magic_mirror", new ItemMagicMirror(BASE)),
        HEART = register("life_crystal", new ItemLifeCrystal(BASE)),
        LIFE_FRUIT = register("life_fruit", new ItemLifeFruit(BASE)),
        RECALL_POTION = register("recall_potion", new ItemRecallPotion(BASE)),
        BROKEN_BAT_WING = register("broken_bat_wing", new Item(BASE)),
        TATTERED_BEE_WING = register("tattered_bee_wing", new Item(BASE)),
        BAT_WINGS = register("bat_wings", new ItemWings(BASE)),
        PHANTOM_WINGS = register("phantom_wings", new ItemWings(BASE)),
        BEE_WINGS = register("bee_wings", new ItemWings(BASE)),
        UMBRELLA = register("umbrella", new ItemUmbrella(BASE)),
        SOUL_EXTRACTOR = register("soul_extractor", new ItemSoulExtractor(BASE)),

        SOUL_OF_FLIGHT = register("soul_of_flight", new Item(BASE)),

        MANDRAKE_ROOT = register("mandrake_root", new Item(BASE)),
        MANDRAKE_SEED = register("mandrake_seed", new BlockItem(ModBlocks.MANDRAKE_CROP, BASE)),
        BUCKTHORN = register("buckthorn", new Item(BASE)),

        TAGLOCK = register("taglock", new ItemTaglock(BASE)),
        BONE_NEEDLE = register("bone_needle", new Item(BASE)),
        POPPET =  register("poppet", new Item(BASE));


    private static Item register(String name, Item item)
    {
        item.setRegistryName(name);
        ITEMS.add(item);
        return item;
    }

}