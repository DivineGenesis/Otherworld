package com.divinegenesis.otherworld.client.renderer;

import com.divinegenesis.otherworld.common.objects.blocks.tileentities.types.HungryChestTE;
import com.divinegenesis.otherworld.common.objects.blocks.types.BlockHungryChest;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.Material;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.DualBrightnessCallback;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HungryChestRenderer<T extends TileEntity & IChestLid> extends TileEntityRenderer<T>
{
    private final ModelRenderer chestUpgrade;
    private final ModelRenderer chestLid;
    private final ModelRenderer chestBottom;
    private final ModelRenderer chestLock;

    public HungryChestRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
        this.chestBottom = new ModelRenderer(64, 64, 0, 19);
        this.chestBottom.addBox(1.0F, 0.0F, 1.0F, 14.0F, 10.0F, 14.0F, 0.0F);

        this.chestLid = new ModelRenderer(64, 64, 0, 0);
        this.chestLid.addBox(1.0F, 0.0F, 0.0F, 14.0F, 5.0F, 14.0F, 0.0F);
        this.chestLid.rotationPointY = 9.0F;
        this.chestLid.rotationPointZ = 1.0F;

        this.chestLock = new ModelRenderer(64, 64, 0, 0);
        this.chestLock.addBox(7.0F, -1.0F, 15.0F, 2.0F, 4.0F, 1.0F, 0.0F);
        this.chestLock.rotationPointY = 8.0F;

        chestUpgrade = new ModelRenderer(0, 0, 0, 0);
    }

    @Override
    public void render(T tileEntityIn, float partialTicks, MatrixStack stack, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
    {
        World world = tileEntityIn.getWorld();
        boolean flag = world != null;
        Direction direction = tileEntityIn.getBlockState().get(BlockHungryChest.FACING);
        stack.push();
        stack.translate(0.5D, 0.5D, 0.5D);
        stack.rotate(Vector3f.YP.rotationDegrees(-direction.getHorizontalAngle()));
        stack.translate(-0.5D, -0.5D, -0.5D);

        BlockHungryChest chest = (BlockHungryChest) tileEntityIn.getBlockState().getBlock();
        TileEntityMerger.ICallbackWrapper<? extends HungryChestTE> iCallbackWrapper;
        if (flag) {
            iCallbackWrapper = chest.getWrapper(tileEntityIn.getBlockState(), world, tileEntityIn.getPos(), true);
        }
        else {
            iCallbackWrapper = TileEntityMerger.ICallback::func_225537_b_;
        }

        float f1 = iCallbackWrapper.apply(BlockHungryChest.getLid((IChestLid) tileEntityIn)).get(partialTicks);
        f1 = 1.0F - f1;
        f1 = 1.0F - f1 * f1 * f1;
        int i = iCallbackWrapper.apply(new DualBrightnessCallback<>()).applyAsInt(combinedLightIn);

        Material material = new Material(Atlases.CHEST_ATLAS, ModModels.locations.HUNGRY_CHEST.getLocation());
        IVertexBuilder ivertexbuilder = material.getBuffer(bufferIn, RenderType::entityCutout);

        renderParts(stack, ivertexbuilder, chestLid, chestLock, chestBottom, f1, i, combinedOverlayIn );
        stack.pop();
    }

    private void renderParts(MatrixStack stack, IVertexBuilder vertexBuilder, ModelRenderer p1, ModelRenderer p2, ModelRenderer p3, float f1, int light, int overlay) {
        p1.rotateAngleX = -(f1 * ((float)Math.PI / 2F));
        p2.rotateAngleX = p2.rotateAngleX;

        p1.render(stack, vertexBuilder, light, overlay);
        p2.render(stack, vertexBuilder, light, overlay);
        p3.render(stack, vertexBuilder, light, overlay);
    }
}
