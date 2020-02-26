package com.divinegenesis.otherworld.common.objects.items;

import com.divinegenesis.otherworld.common.objects.items.types.*;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems
{
    public static final List<Item> ITEMS = new ArrayList<Item>();
    public static final Item
        ENDER_POUCH = new ItemEnderPouch("ender_pouch"),
        TOTEM_SOULBOUND = new ItemBase("totem_soulbound"),
        MAGIC_MIRROR = new ItemMagicMirror("magic_mirror"),
        HEART = new ItemLifeCrystal("life_crystal"),
        LIFE_FRUIT = new ItemLifeFruit("life_fruit"),
        RECALL_POTION = new ItemRecallPotion("recall_potion"),
        WINGS = new ItemWings("wings"),
        UMBRELLA = new ItemUmbrella("umbrella"),
        SOUL_EXTRACTOR = new ItemSoulExtractor("soul_extractor"),

        MANDRAKE_ROOT = new ItemBase("mandrake_root"),
        BUCKTHORN = new ItemBase("buckthorn"),

        TAGLOCK = new ItemTaglock("taglock"),
        BONE_NEEDLE = new ItemBase("bone_needle"),
        POPPET = new ItemBase("poppet");
}