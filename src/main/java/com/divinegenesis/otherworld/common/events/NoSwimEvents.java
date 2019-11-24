package com.divinegenesis.otherworld.common.events;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class NoSwimEvents
{
    public static void swim(LivingEvent.LivingUpdateEvent event)
    {
        if(event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            if(player.world.isRemote)
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
        }
    }
}
