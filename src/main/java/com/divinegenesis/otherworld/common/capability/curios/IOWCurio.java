package com.divinegenesis.otherworld.common.capability.curios;

import net.minecraft.entity.LivingEntity;
import top.theillusivec4.curios.api.capability.ICurio;

import javax.annotation.Nonnull;

public class IOWCurio implements ICurio
{
    @Nonnull
    @Override
    public DropRule getDropRule(LivingEntity livingEntity)
    {
        return DropRule.ALWAYS_KEEP;
    }

    @Override
    public boolean canRightClickEquip() {
        return true;
    }
}
