package com.divinegenesis.otherworld.client.renderer.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class WingModel<T  extends LivingEntity> extends BipedModel<T> {

    public ModelRenderer wings;

    public WingModel() {
        super(0f);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.wings = new ModelRenderer(this, 0, 0);
        this.wings.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wings.addBox(-3.5F, 1.0F, 2.0F, 7, 9, 4, 0.0F);
    }
}
