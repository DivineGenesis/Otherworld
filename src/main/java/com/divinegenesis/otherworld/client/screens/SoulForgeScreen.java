package com.divinegenesis.otherworld.client.screens;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.containers.types.SoulForgeContainer;
import net.minecraft.client.gui.recipebook.BlastFurnaceRecipeGui;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class SoulForgeScreen extends AbstractFurnaceScreen<SoulForgeContainer> {
    private static ResourceLocation GUI = new ResourceLocation(Otherworld.MODID, "textures/gui/container/soul_forge.png");

    public SoulForgeScreen(SoulForgeContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, new BlastFurnaceRecipeGui(), inv, titleIn, GUI);
    }
}
