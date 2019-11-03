package com.divinegenesis.otherworld.common.helpers;

import com.divinegenesis.otherworld.Otherworld;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;

import java.util.UUID;

public class HealthHelper
{
    public static void giveHealth(PlayerEntity player, HealthType type)
    {
        IAttributeInstance health = player.getAttribute(SharedMonsterAttributes.MAX_HEALTH);

        if(!isMaxHealth(player, type))
        {
            int oldhp = getHealth(player, type);

            if(health.getModifier(type.uuid) != null)
                health.removeModifier(type.uuid);

            health.applyModifier(new AttributeModifier(type.uuid,
                    Otherworld.MODID + ":" + type.name, oldhp + 2, AttributeModifier.Operation.ADDITION));
        }
    }

    public static int getHealth(PlayerEntity player, HealthType type)
    {
        AttributeModifier health = player.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getModifier(type.uuid);

        if(health == null)
            return 0;

        return (int) health.getAmount();
    }

    public static boolean isMaxHealth(PlayerEntity player, HealthType type)
    {
        IAttributeInstance health = player.getAttribute(SharedMonsterAttributes.MAX_HEALTH);
        AttributeModifier modifier = health.getModifier(type.uuid);

        if(modifier != null)
        {
            if(modifier.getAmount() == type.maxHealth) return true;
        }
        return false;
    }

    public enum HealthType
    {
        LIFE_CRYSTAL("life_crystal", "c0305fb6-512f-40b6-ad86-822d0186866b", 20),
        LIFE_FRUIT("life_fruit", "11d0e6b9-ed5c-411d-93fd-9afe8a4e832e", 20);

        private HealthType(String name, String id, int max)
        {
            this.name = name;
            uuid = UUID.fromString(id);
            maxHealth = max;
        }

        private String name;
        private UUID uuid;
        private int maxHealth;

        public int getMaxHealth() {
            return maxHealth;
        }
    }
}
