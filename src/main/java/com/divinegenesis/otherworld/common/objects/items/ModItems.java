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
        BROKEN_BAT_WING = new ItemBase("broken_bat_wing"),
        TATTERED_BEE_WING = new ItemBase("tattered_bee_wing"),
        BAT_WINGS = new ItemWings("bat_wings"),
        PHANTOM_WINGS = new ItemWings("phantom_wings"),
        BEE_WINGS = new ItemWings("bee_wings"),
        UMBRELLA = new ItemUmbrella("umbrella"),
        SOUL_EXTRACTOR = new ItemSoulExtractor("soul_extractor"),

        SOUL_OF_FLIGHT = new ItemBase("soul_of_flight"),

        MANDRAKE_ROOT = new ItemBase("mandrake_root"),
        MANDRAKE_SEED = new ItemBase("mandrake_seed"),
        BUCKTHORN = new ItemBase("buckthorn"),

        TAGLOCK = new ItemTaglock("taglock"),
        BONE_NEEDLE = new ItemBase("bone_needle"),
        POPPET = new ItemBase("poppet");
}