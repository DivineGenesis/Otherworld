package com.divinegenesis.otherworld.common.objects.entities;

import com.divinegenesis.otherworld.common.objects.entities.types.MandrakeEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class ModEntities
{
        public static final List<EntityType<?>> ENTITY_TYPES = new ArrayList<>();
        public static EntityType<MandrakeEntity> MANDRAKE = register("mandrake", EntityType.Builder.create(MandrakeEntity::new, EntityClassification.MONSTER).size(1f, 1f));

        private static <T extends Entity>EntityType<T> register(String name, EntityType.Builder<T> builder)
        {
                EntityType type = builder.build("").setRegistryName(name);
                ENTITY_TYPES.add(type);
                return type;
        }
}
