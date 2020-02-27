package com.divinegenesis.otherworld.common.events;

import com.divinegenesis.otherworld.common.objects.enchants.ModEnchants;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class ReapingEvent
{
    @SubscribeEvent
    public static void onMobDeath(LivingDeathEvent event)
    {
        if(event.getEntityLiving().getEntityWorld().isRemote())
            return;

        if(event.getSource().getTrueSource() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();

            if(EnchantmentHelper.getEnchantments(player.getHeldItemMainhand()).get(ModEnchants.REAPING) != null)
            {
                System.out.println("SOULS");
            }
        }
    }
}
