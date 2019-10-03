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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber
public class EventHandler
{
    private static Map<String, List<ItemStack>> returnList = new HashMap<String, List<ItemStack>>();
    private static List<BlockState> placeQueue = new ArrayList<>();
    private static List<BlockPos> placeQueuePos = new ArrayList<>();

    @SubscribeEvent
    public static void OnDeath(LivingDeathEvent event)
    {
        if(event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            List<ItemStack> inv = new ArrayList<>(player.inventory.mainInventory);
            returnList.put(player.getUniqueID().toString(), inv);
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
        if(event.isWasDeath() && returnList.containsKey(player.getUniqueID().toString()))
        {
            for(int i = 0; i < 36; i++)
            {
                ItemStack stack = returnList.get(player.getUniqueID().toString()).get(i);
                player.inventory.setInventorySlotContents(i, EnchantmentHelper.getEnchantments(stack).get(ModEnchants.soulbound) != null ? stack : ItemStack.EMPTY);
            }

            returnList.remove(player.getUniqueID().toString());
        }
    }
}
