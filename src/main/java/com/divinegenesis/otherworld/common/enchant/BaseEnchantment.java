package com.divinegenesis.otherworld.common.enchant;

import com.divinegenesis.otherworld.common.ModEnchants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class BaseEnchantment extends Enchantment
{
    int levels = 1;

    public BaseEnchantment()
    {
        super(Rarity.VERY_RARE, EnchantmentType.ALL, EquipmentSlotType.values());
        ModEnchants.ENCHANTS.add(this);
    }

    public BaseEnchantment(int levels)
    {
        super(Rarity.VERY_RARE, EnchantmentType.ALL, EquipmentSlotType.values());
        ModEnchants.ENCHANTS.add(this);
        this.levels = levels;
    }

    @Override
    public int getMaxLevel() {
        return levels;
    }
}
