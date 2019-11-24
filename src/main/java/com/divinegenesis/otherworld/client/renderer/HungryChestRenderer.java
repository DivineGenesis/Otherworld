package com.divinegenesis.otherworld.client.renderer;

import com.divinegenesis.otherworld.common.blocks.tileentities.HungryChestTE;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.model.ChestModel;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class HungryChestRenderer<t extends TileEntity & IChestLid> extends TileEntityRenderer
{

    private final ChestModel chestModel = new ChestModel();
    @Override
    public void render(TileEntity tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage) {
        GlStateManager.enableDepthTest();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);

        HungryChestTE tileEntity = (HungryChestTE) tileEntityIn;

        BlockState blockstate = tileEntity.getBlockState();

        if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scalef(4.0F, 4.0F, 1.0F);
            GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }
        else
        {
            this.bindTexture(new ResourceLocation("otherworld", "textures/model/hungrychest"));
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        }

        GlStateManager.pushMatrix();

        GlStateManager.enableRescaleNormal();
        GlStateManager.translatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
        GlStateManager.scalef(1.0F, -1.0F, -1.0F);

        float f = blockstate.get(ChestBlock.FACING).getHorizontalAngle();
        if ((double) Math.abs(f) > 1.0E-5D)
        {
            GlStateManager.translatef(0.5F, 0.5F, 0.5F);
            GlStateManager.rotatef(f, 0.0F, 1.0F, 0.0F);
            GlStateManager.translatef(-0.5F, -0.5F, -0.5F);
        }
        this.chestModel.renderAll();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();


        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
}
