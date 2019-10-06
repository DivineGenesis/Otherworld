package com.divinegenesis.otherworld.common;

import com.divinegenesis.otherworld.common.item.ItemBase;
import com.divinegenesis.otherworld.common.item.ItemEnderPouch;
import com.divinegenesis.otherworld.common.item.ItemKronorium;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems
{
    public static final List<Item> ITEMS = new ArrayList<Item>();
    public static final Item
        ENDER_POUCH = new ItemEnderPouch("ender_pouch"),
        KRONORIUM = new ItemKronorium(),
        TOTEM_SOULBOUND = new ItemBase("totem_soulbound");

}
