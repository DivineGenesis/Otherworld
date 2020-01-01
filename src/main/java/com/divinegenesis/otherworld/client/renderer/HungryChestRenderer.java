package com.divinegenesis.otherworld.client.renderer;

import com.divinegenesis.otherworld.common.blocks.tileentities.HungryChestTE;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class HungryChestRenderer<t extends TileEntity & IChestLid> extends TileEntityRenderer {
    public HungryChestRenderer(TileEntityRendererDispatcher p_i226006_1_) {
        super(p_i226006_1_);
    }

    @Override
    public void func_225616_a_(TileEntity p_225616_1_, float p_225616_2_, MatrixStack p_225616_3_, IRenderTypeBuffer p_225616_4_, int p_225616_5_, int p_225616_6_) {

    }
//    @Override
//    public void render(TileEntity tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage) {
//        GlStateManager.enableDepthTest();
//        GlStateManager.depthFunc(515);
//        GlStateManager.depthMask(true);
//
//        HungryChestTE tileEntity = (HungryChestTE) tileEntityIn;
//
//        BlockState blockstate = tileEntity.getBlockState();
//
//        if (destroyStage >= 0)
//        {
//            this.bindTexture(DESTROY_STAGES[destroyStage]);
//            GlStateManager.matrixMode(5890);
//            GlStateManager.pushMatrix();
//            GlStateManager.scalef(4.0F, 4.0F, 1.0F);
//            GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
//            GlStateManager.matrixMode(5888);
//        }
//        else
//        {
//            this.bindTexture(new ResourceLocation("otherworld", "textures/model/hungrychest"));
//            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//        }
//
//        GlStateManager.pushMatrix();
//
//        GlStateManager.enableRescaleNormal();
//        GlStateManager.translatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
//        GlStateManager.scalef(1.0F, -1.0F, -1.0F);
//
//        float f = blockstate.get(ChestBlock.FACING).getHorizontalAngle();
//        if ((double) Math.abs(f) > 1.0E-5D)
//        {
//            GlStateManager.translatef(0.5F, 0.5F, 0.5F);
//            GlStateManager.rotatef(f, 0.0F, 1.0F, 0.0F);
//            GlStateManager.translatef(-0.5F, -0.5F, -0.5F);
//        }
//        GlStateManager.disableRescaleNormal();
//        GlStateManager.popMatrix();
//
//
//        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//        if (destroyStage >= 0)
//        {
//            GlStateManager.matrixMode(5890);
//            GlStateManager.popMatrix();
//            GlStateManager.matrixMode(5888);
//        }
//    }
    }