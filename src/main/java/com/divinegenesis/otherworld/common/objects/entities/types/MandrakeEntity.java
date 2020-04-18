package com.divinegenesis.otherworld.common.objects.entities.types;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class MandrakeEntity extends MonsterEntity {

    public MandrakeEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 5.0F));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.5D, true));
        this.goalSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }
}