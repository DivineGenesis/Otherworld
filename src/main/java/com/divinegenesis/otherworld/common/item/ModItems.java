package com.divinegenesis.otherworld.common.item;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.item.types.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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
        UMBRELLA = new ItemUmbrella("umbrella");

}
