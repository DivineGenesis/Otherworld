package com.divinegenesis.otherworld.client.events;

import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class SpeedBlockEvent
{
    @SubscribeEvent
    public static void speedy(TickEvent.PlayerTickEvent event)
    {
        if(event.side.isClient() && event.player.onGround && event.phase == TickEvent.Phase.START && event.player instanceof ClientPlayerEntity)
        {
            ClientPlayerEntity playerEntity = (ClientPlayerEntity) event.player;
            BlockState state = playerEntity.getEntityWorld().getBlockState(new BlockPos(playerEntity.getPosX(), playerEntity.getPosY() - (1/16D), playerEntity.getPosZ()));
            if(state.getBlock() == ModBlocks.TRAVELLER_PAVEMENT)
            {
                playerEntity.updateEntityActionState();

                if( (playerEntity.moveForward != 0 || playerEntity.moveStrafing != 0) && !playerEntity.isInWater() )
                {
                    double x = playerEntity.getMotion().x * (1.4 + .05);
                    double z = playerEntity.getMotion().z * (1.4 + .05);
                    playerEntity.setMotion(x, playerEntity.getMotion().y, z);
                }
            }
        }
    }



}