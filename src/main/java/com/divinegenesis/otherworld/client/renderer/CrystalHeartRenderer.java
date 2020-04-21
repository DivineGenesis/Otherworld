package com.divinegenesis.otherworld.client.renderer;

import com.divinegenesis.otherworld.common.objects.items.ModItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class CrystalHeartRenderer extends TileEntityRenderer {

    private float degrees = 0;
    private float height = 0;
    private  boolean up = true;
    public CrystalHeartRenderer(TileEntityRendererDispatcher p_i226006_1_) {
        super(p_i226006_1_);
    }

    @Override
    public void render(TileEntity tileEntity, float v, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int i, int i1)
    {
        matrixStack.push();
        matrixStack.translate(0.5d, 1.2d+height, 0.5d);
        matrixStack.rotate(Vector3f.YP.rotationDegrees(degrees));
        matrixStack.scale(0.7f, 0.7f, 0.7f);

        Minecraft.getInstance().getItemRenderer().renderItem(new ItemStack(ModItems.HEART), ItemCameraTransforms.TransformType.NONE, i, i1, matrixStack, iRenderTypeBuffer);
        matrixStack.pop();

        if(degrees < 360)
            degrees++;
        else
            degrees = 0;

        if(up)
            height += 0.001;
        else
            height -= 0.001;

        if(height > 0.05) up = false;
        else if(height < -0.05) up = true;

    }
}
