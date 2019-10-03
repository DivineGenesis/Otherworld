package com.divinegenesis.otherworld.common.events;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.ModBlocks;
import com.divinegenesis.otherworld.common.ModEnchants;
import com.divinegenesis.otherworld.common.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber
public class EventHandler
{
    private static Map<UUID, List<ItemStack>> returnList = new HashMap<UUID, List<ItemStack>>();

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
