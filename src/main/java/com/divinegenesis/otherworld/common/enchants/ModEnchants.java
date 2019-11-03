package com.divinegenesis.otherworld.common.enchants;

import com.divinegenesis.otherworld.common.enchants.types.BaseEnchantment;
import com.divinegenesis.otherworld.common.enchants.types.LifeStealEnchantment;
import net.minecraft.enchantment.Enchantment;

import java.util.ArrayList;
import java.util.List;

public class ModEnchants
{
    public static final List<Enchantment> ENCHANTS = new ArrayList<Enchantment>();

    public static final Enchantment
            SOULBOUND = new BaseEnchantment().setRegistryName("soulbound"),
            LIFE_STEAL = new LifeStealEnchantment().setRegistryName("life_steal"),
            BEHEADING = new BaseEnchantment(5).setRegistryName("beheading"),
            REPAIR = new BaseEnchantment(3).setRegistryName("repair"),
            AUTO_SMELT = new BaseEnchantment().setRegistryName("auto_smelt"),
            AUTO_PICKUP = new BaseEnchantment().setRegistryName("auto_pickup");
}
