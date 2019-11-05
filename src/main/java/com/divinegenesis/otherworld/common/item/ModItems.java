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
    public static final DeferredRegister<Item> ITEMSA = new DeferredRegister<>(ForgeRegistries.ITEMS, Otherworld.MODID);
    public static final Item
        ENDER_POUCH = new ItemEnderPouch("ender_pouch"),
        KRONORIUM = new ItemKronorium(),
        TOTEM_SOULBOUND = new ItemBase("totem_soulbound"),
        SCROLL_ADDITIONAL_ACCESSORY = new ItemScrollAccessories("scroll_of_accessory"),
        MAGIC_MIRROR = new ItemMagicMirror("magic_mirror"),
        CLOUD_IN_BOTTLE = new ItemBase("cloud_in_a_bottle", new Item.Properties().maxStackSize(1)),
        HEART = new ItemLifeCrystal("life_crystal"),
        LIFE_FRUIT = new ItemLifeFruit("life_fruit"),
        MIMIC_CORE = new ItemBase("mimic_core");

}
