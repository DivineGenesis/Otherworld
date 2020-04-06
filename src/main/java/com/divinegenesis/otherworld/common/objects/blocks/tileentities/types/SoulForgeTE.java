package com.divinegenesis.otherworld.common.objects.blocks.tileentities.types;

import com.divinegenesis.otherworld.common.containers.types.SoulForgeContainer;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.ModTileEntities;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class SoulForgeTE extends AbstractFurnaceTileEntity
{
    public SoulForgeTE()
    {
        super(ModTileEntities.SOUL_FORGE, IRecipeType.BLASTING);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.soulforge");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new SoulForgeContainer(id, player, this, this.furnaceData);
    }
}