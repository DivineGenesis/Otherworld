package com.divinegenesis.otherworld.client.renderer.entity;

import com.divinegenesis.otherworld.common.objects.entities.types.MandrakeEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;

public class MandrakeRenderer extends BipedRenderer<MandrakeEntity, BipedModel<MandrakeEntity>>
{

    public MandrakeRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new Model(), 0F);
    }

    private static class Model extends BipedModel<MandrakeEntity> {


        public Model() {
            super(Model::makeRenderType, 0, 0, 64, 64);
        }

        private static RenderType makeRenderType(ResourceLocation location)
        {
            return RenderType.cutout();
        }
    }
}