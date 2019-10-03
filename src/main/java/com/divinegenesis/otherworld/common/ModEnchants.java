package com.divinegenesis.otherworld.common;

import com.divinegenesis.otherworld.common.enchant.*;
import net.minecraft.enchantment.Enchantment;

import java.util.ArrayList;
import java.util.List;

public class ModEnchants
{
    public static final List<Enchantment> ENCHANTS = new ArrayList<Enchantment>();

    public static final Enchantment
            soulbound = new BaseEnchantment().setRegistryName("soulbound"),
            life_steal = new LifeStealEnchantment().setRegistryName("life_steal"),
            beheading = new BaseEnchantment(5).setRegistryName("beheading"),
            repair = new BaseEnchantment(3).setRegistryName("repair"),
            auto_smelt = new BaseEnchantment().setRegistryName("auto_smelt");
}
