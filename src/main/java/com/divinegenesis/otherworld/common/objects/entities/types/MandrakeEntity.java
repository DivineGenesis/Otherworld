package com.divinegenesis.otherworld.common.objects.entities.types;

import com.divinegenesis.otherworld.common.objects.entities.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.World;

public class MandrakeEntity extends MobEntity{
    public MandrakeEntity(EntityType<? extends MobEntity> type, World worldIn) {
        super((EntityType<? extends MobEntity>) ModEntities.MANDRAKE, worldIn);
    }
}
