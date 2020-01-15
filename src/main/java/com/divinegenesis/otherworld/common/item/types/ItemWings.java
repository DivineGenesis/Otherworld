package com.divinegenesis.otherworld.common.item.types;

import com.divinegenesis.otherworld.common.capability.CuriosItemCapability;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import top.theillusivec4.curios.api.capability.ICurio;

import javax.annotation.Nullable;
import java.lang.reflect.Field;

public class ItemWings extends ItemBase {

    public ItemWings(String name) {
        super(name);
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return CuriosItemCapability.createProvider(new ICurio() {
            @Override
            public void onCurioTick(String identifier, int index, LivingEntity livingEntity) {
                if(livingEntity instanceof PlayerEntity)
                {
                    PlayerEntity player = (PlayerEntity) livingEntity;

                    if(true)
                    {
                        boolean isJumping = ObfuscationReflectionHelper.getPrivateValue(LivingEntity.class, livingEntity, "isJumping");
                        if(!player.onGround && isJumping)
                        {
                            Vec3d vec = player.getMotion();
                            player.setMotion(new Vec3d(vec.x, .3D, vec.z));
                        }

                    }
                }
            }
        });
    }
}
