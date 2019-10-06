package com.divinegenesis.otherworld.common.events;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.ModEnchants;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber
public class EventHandler
{
    private static Map<UUID, List<ItemStack>> returnList = new HashMap<UUID, List<ItemStack>>();

    //EVENT NOT FULLY IMPLEMENTED TODO: AUTO-PICKUP, AUTO-SMELT
    @SubscribeEvent
    public static void onBlockHarvest(BlockEvent.HarvestDropsEvent event)
    {
        Otherworld.LOGGER.info("event fired");
    }

    @SubscribeEvent
    public static void OnDeath(LivingDeathEvent event)
    {
        if(event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            List<ItemStack> inv = new ArrayList<>();

            for(int i = 0; i < player.inventory.getSizeInventory(); i++)
                inv.add(player.inventory.getStackInSlot(i));

            returnList.put(player.getUniqueID(), inv);
        }
    }

    @SubscribeEvent
    public static void OnDeathDrop(LivingDropsEvent event)
    {
        if(event.getEntity() instanceof PlayerEntity)
        {
            event.getDrops().removeIf(itemEntity -> EnchantmentHelper.getEnchantments(itemEntity.getItem()).get(ModEnchants.soulbound) != null);
        }
    }

    @SubscribeEvent
    public static void OnRespawn(PlayerEvent.Clone event)
    {
        PlayerEntity player = event.getPlayer();
        if(event.isWasDeath() && returnList.containsKey(player.getUniqueID()))
        {
            for(int i = 0; i < returnList.get(player.getUniqueID()).size(); i++)
            {
                ItemStack stack = returnList.get(player.getUniqueID()).get(i);
                player.inventory.setInventorySlotContents(i, EnchantmentHelper.getEnchantments(stack).get(ModEnchants.soulbound) != null ? stack : ItemStack.EMPTY);
            }

            returnList.remove(player.getUniqueID());
        }
    }
}
