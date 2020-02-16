package com.divinegenesis.otherworld.common;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.blocks.tileentities.HungryChestTE;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ObjectHolder;

public class ModTileEntities
{
    @ObjectHolder("otherworld:hungrychest_te")
    public static TileEntityType<?> HUNGRY_CHEST;
}
