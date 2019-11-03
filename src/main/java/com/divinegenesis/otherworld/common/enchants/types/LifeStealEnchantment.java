package com.divinegenesis.otherworld.common.enchants.types;

import com.divinegenesis.otherworld.common.enchants.types.BaseEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

import java.util.Random;

public class LifeStealEnchantment extends BaseEnchantment
{
    public LifeStealEnchantment()
    {
    }

    @Override
    public void onEntityDamaged(LivingEntity user, Entity e, int level) {
        Random random = new Random();
        if(random.nextInt(100) < 25*level)
            user.heal(.5f);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
