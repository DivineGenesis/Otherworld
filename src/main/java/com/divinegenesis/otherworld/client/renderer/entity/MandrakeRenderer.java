package com.divinegenesis.otherworld.client.renderer.entity;

import com.divinegenesis.otherworld.common.objects.entities.types.MandrakeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.ZombieModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;

public class MandrakeRenderer extends BipedRenderer<MandrakeEntity, BipedModel<MandrakeEntity>>
{

    public MandrakeRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new Model(), 0F);
    }

    private static class Model extends BipedModel<MandrakeEntity>
    {
        private final ModelRenderer bb_main;

        public Model() {
            super(Model::makeRenderType, 0, 0, 64, 64);
            textureWidth = 16;
            textureHeight = 16;
            bb_main = new ModelRenderer(this);
            bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
            bb_main.addBox(-1.0F, -2.0F, -3.0F, 4, 1, 4, 0.0F, false);
            bb_main.addBox(0.0F, -5.0F, -2.0F, 2, 0, 2, 0.0F, false);
            bb_main.addBox(0.0F, -8.0F, -2.0F, 2, 0, 2, 0.0F, false);
            bb_main.addBox(1.0F, -8.5F, -1.25F, 1, 0, 1, 0.0F, false);
            bb_main.addBox(-1.0F, -7.5F, -2.25F, 4, 2, 2, 0.0F, false);
            bb_main.addBox(1.75F, -1.0F, -4.0F, 1, 1, 4, 0.0F, false);
            bb_main.addBox(3.25F, -4.0F, -4.0F, 1, 1, 4, 0.0F, false);
            bb_main.addBox(-2.25F, -4.0F, -4.0F, 1, 1, 4, 0.0F, false);
            bb_main.addBox(-0.75F, -1.0F, -4.0F, 1, 1, 4, 0.0F, false);
            bb_main.addBox(-1.25F, -5.0F, -3.25F, 4, 3, 4, 0.0F, false);
        }

        public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
            modelRenderer.rotateAngleX = x;
            modelRenderer.rotateAngleY = y;
            modelRenderer.rotateAngleZ = z;
        }

        private static RenderType makeRenderType(ResourceLocation location)
        {
            return RenderType.cutout();
        }

        @Override
        public void render(MatrixStack stack, IVertexBuilder iVertexBuilder, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
            bb_main.render(stack, iVertexBuilder, p_225598_3_, p_225598_4_);
        }
    }
}