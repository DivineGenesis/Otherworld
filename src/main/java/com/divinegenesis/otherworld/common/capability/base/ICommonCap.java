package com.divinegenesis.otherworld.common.capability.base;

import net.minecraft.nbt.CompoundNBT;

public interface ICommonCap
{
    CompoundNBT saveToNBT();
    void loadFromNBT(CompoundNBT value);
}
