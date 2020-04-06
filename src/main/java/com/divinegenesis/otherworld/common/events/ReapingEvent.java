package com.divinegenesis.otherworld.common.events;

import com.divinegenesis.otherworld.common.objects.enchants.ModEnchants;
import com.divinegenesis.otherworld.common.objects.items.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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

                if(event.getEntity() instanceof IFlyingAnimal || event.getEntity() instanceof FlyingEntity)
                {
                    event.getEntity().entityDropItem(new ItemStack(ModItems.SOUL_OF_FLIGHT));
                }
            }
        }
    }
}