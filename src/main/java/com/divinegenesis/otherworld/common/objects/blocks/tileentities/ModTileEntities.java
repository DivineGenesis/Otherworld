package com.divinegenesis.otherworld.common.objects.blocks.tileentities;

import com.divinegenesis.otherworld.common.objects.blocks.tileentities.types.HungryChestTE;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModTileEntities
{
    @ObjectHolder("otherworld:hungrychest_te")
    public static TileEntityType<HungryChestTE> HUNGRY_CHEST;

    @ObjectHolder("otherworld:soulforge_te")
    public static TileEntityType<?> SOUL_FORGE;
}
