package com.divinegenesis.otherworld.common.events;

import com.divinegenesis.otherworld.common.Config;
import com.divinegenesis.otherworld.common.OWTags;
import com.divinegenesis.otherworld.common.capability.OWPlayerCap;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SanityEvents
{
    @SubscribeEvent
    public static void inDarkness(TickEvent.PlayerTickEvent event)
    {
        PlayerEntity player = event.player;

        if (!player.world.isRemote())
        {
            if (player.world.getBlockState(player.getPosition()).getLightValue() < 8)
            {
                player.getCapability(OWPlayerCap.DATA).ifPresent(iPlayerData ->
                 iPlayerData.setSanity(iPlayerData.getSanity()-Config.COMMON.INSANITY_FROM_DARKNESS.get()));
            }
        }
    }

    @SubscribeEvent
    public static void onBreakBlock(BlockEvent.BreakEvent event)
    {
        if (!event.getWorld().isRemote())
        {
            Block block = event.getState().getBlock();
            PlayerEntity player = event.getPlayer();
            LazyOptional<OWPlayerCap.IPlayerData> optional = player.getCapability(OWPlayerCap.DATA);
            double sanity = 0;

            if (block.isIn(OWTags.Blocks.INSANITY))
            {
                sanity = -2;
            }
            else if (block.isIn(OWTags.Blocks.SANITY))
            {
                sanity = 2;
            }

            double finalSanity = sanity;
            optional.ifPresent(iPlayerData ->
            {
                iPlayerData.setSanity(iPlayerData.getSanity()+finalSanity);
            });
        }
    }
}
