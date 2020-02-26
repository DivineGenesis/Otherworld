package com.divinegenesis.otherworld.common.events;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

@Mod.EventBusSubscriber()
public class NoSwimEvents
{
    @SubscribeEvent
    public static void swim(LivingEvent.LivingUpdateEvent event)
    {
        if(event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            if(player.world.isRemote)
            {
                if(!player.onGround)
                {
                    if(player.isSwimming())
                    {
                        Vec3d vec = player.getMotion();
                        player.setMotion(new Vec3d(vec.x, -.1D, vec.z));
                    }
                    else if(player.isInWater())
                    {
                        Vec3d vec = player.getMotion();
                        player.setMotion(new Vec3d(vec.x, -.05D, vec.z));

                    }
                }
                else
                {
                    boolean isJumping = ObfuscationReflectionHelper.getPrivateValue(LivingEntity.class, event.getEntityLiving(), "isJumping");
                    if(player.isInWater() && isJumping)
                    {
                        Vec3d vec = player.getMotion();
                        player.setVelocity(vec.x, vec.y+1d, vec.z);
                    }
                }


            }
        }
    }
}
