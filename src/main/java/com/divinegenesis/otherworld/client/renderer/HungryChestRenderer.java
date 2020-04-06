package com.divinegenesis.otherworld.client.renderer;

import com.divinegenesis.otherworld.common.objects.blocks.tileentities.types.HungryChestTE;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class HungryChestRenderer<t extends TileEntity & IChestLid> extends TileEntityRenderer
{
    public HungryChestRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(TileEntity tileEntityIn, float partialTicks, MatrixStack stack, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
    {
        HungryChestTE te = (HungryChestTE) tileEntityIn;


    }
}
