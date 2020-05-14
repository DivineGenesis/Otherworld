package com.divinegenesis.otherworld.common.events;

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
                {
                    CompoundNBT nbt = iPlayerData.saveToNBT();
                    nbt.putInt("sanity", iPlayerData.sanity()-2);
                    iPlayerData.loadFromNBT(nbt);
                });
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
            int sanity = 0;

            if (block.isIn(OWTags.Blocks.INSANITY))
            {
                sanity = -2;
            }
            else if (block.isIn(OWTags.Blocks.SANITY))
            {
                sanity = 2;
            }

            int finalSanity = sanity;
            optional.ifPresent(iPlayerData ->
            {
                CompoundNBT nbt = iPlayerData.saveToNBT();
                nbt.putInt("sanity", iPlayerData.sanity()+finalSanity);
                iPlayerData.loadFromNBT(nbt);
            });
        }
    }
}
