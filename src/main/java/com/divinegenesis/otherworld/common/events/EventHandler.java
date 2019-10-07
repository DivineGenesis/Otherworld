package com.divinegenesis.otherworld.common.events;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.ModEnchants;
import com.divinegenesis.otherworld.common.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.ItemEntity;
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
        event.getDrops().forEach(itemStack -> event.getHarvester().inventory.addItemStackToInventory(itemStack));
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
            for(ItemEntity e : event.getDrops())
            {
                if(e.getItem().equals(ModItems.TOTEM_SOULBOUND))
                {
                    event.getDrops().clear();
                    break;
                }
            }
            if(!event.getDrops().isEmpty())
                event.getDrops().removeIf(itemEntity -> EnchantmentHelper.getEnchantments(itemEntity.getItem()).get(ModEnchants.soulbound) != null);
        }
    }

    @SubscribeEvent
    public static void OnRespawn(PlayerEvent.Clone event)
    {
        PlayerEntity player = event.getPlayer();
        UUID uuid = player.getUniqueID();

        if(event.isWasDeath() && returnList.containsKey(uuid))
        {
            List<ItemStack> items = returnList.get(uuid);
            boolean hasTotem = false;


            for(ItemStack stack : items)
            {
                if(stack.getItem().equals(ModItems.TOTEM_SOULBOUND))
                {
                    hasTotem = true;
                    items.set(items.indexOf(stack), ItemStack.EMPTY);
                    break;
                }
            }

            for(int i = 0; i < items.size(); i++)
            {
                ItemStack stack = returnList.get(uuid).get(i);
                if(!hasTotem)
                    player.inventory.setInventorySlotContents(i, EnchantmentHelper.getEnchantments(stack).get(ModEnchants.soulbound) != null ? stack : ItemStack.EMPTY);
                else
                    player.inventory.setInventorySlotContents(i, stack);
            }

            returnList.remove(player.getUniqueID());
        }
    }
}
