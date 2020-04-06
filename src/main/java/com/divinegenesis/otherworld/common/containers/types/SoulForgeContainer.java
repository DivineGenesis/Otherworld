package com.divinegenesis.otherworld.common.containers.types;

import com.divinegenesis.otherworld.common.containers.ModContainers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;

public class SoulForgeContainer extends AbstractFurnaceContainer
{
    public SoulForgeContainer(int id, PlayerInventory player, IInventory inv, IIntArray furnaceData) {
        super(ModContainers.SOULFORGE_CONTAINER.get(), IRecipeType.BLASTING, id, player, inv, furnaceData);
    }

    public SoulForgeContainer(int i, PlayerInventory playerInventory, PacketBuffer packetBuffer)
    {
        super(ModContainers.SOULFORGE_CONTAINER.get(), IRecipeType.BLASTING, i, playerInventory);
    }

}