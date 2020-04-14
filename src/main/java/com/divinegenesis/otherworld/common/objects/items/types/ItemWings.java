package com.divinegenesis.otherworld.common.objects.items.types;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.capability.curios.CuriosItemCapability;
import com.divinegenesis.otherworld.common.capability.curios.IOWCurio;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import top.theillusivec4.curios.api.capability.ICurio;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWings extends Item {

    public ItemWings(Properties properties) {
        super(properties);
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> list, ITooltipFlag flag) {
        //super.addInformation(stack, world, list, flag);
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt)
    {
        return CuriosItemCapability.createProvider(new IOWCurio()
        {
            private Object model;
            @Override
            public void onCurioTick(String identifier, int index, LivingEntity livingEntity)
            {
                if (livingEntity instanceof PlayerEntity)
                {
                    PlayerEntity player = (PlayerEntity) livingEntity;
                    boolean isJumping = ObfuscationReflectionHelper.getPrivateValue(LivingEntity.class, livingEntity, "isJumping");

                    if (!player.onGround && isJumping)
                    {
                        Vec3d vec = player.getMotion();
                        player.setMotion(new Vec3d(vec.x, vec.y + .0999999995D, vec.z));
                    }
                }
            }

            @Override
            public boolean hasRender(String identifier, LivingEntity livingEntity) {
                return true;
            }

            @Override
            public void render(String identifier, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

                matrixStack.push();
                ICurio.RenderHelper.translateIfSneaking(matrixStack, livingEntity);
                ICurio.RenderHelper.rotateIfSneaking(matrixStack, livingEntity);
                matrixStack.scale(1.2f, 1.2f, 1.2f);
                matrixStack.translate(0.3d, 0.1d, 0.3d);
                matrixStack.rotate(Vector3f.ZP.rotationDegrees(180f));
                matrixStack.rotate(Vector3f.YP.rotationDegrees(33.3f));
                Minecraft.getInstance().getItemRenderer().renderItem(stack, ItemCameraTransforms.TransformType.NONE, light, OverlayTexture.DEFAULT_LIGHT, matrixStack, renderTypeBuffer);
                matrixStack.pop();
                ICurio.RenderHelper.translateIfSneaking(matrixStack, livingEntity);
                ICurio.RenderHelper.rotateIfSneaking(matrixStack, livingEntity);
                matrixStack.scale(1.2f, 1.2f, 1.2f);
                matrixStack.translate(-0.3d, 0.1d, 0.3d);
                matrixStack.rotate(Vector3f.ZP.rotationDegrees(180f));
                matrixStack.rotate(Vector3f.YP.rotationDegrees(147.7f));
                Minecraft.getInstance().getItemRenderer().renderItem(stack, ItemCameraTransforms.TransformType.NONE, light, OverlayTexture.DEFAULT_LIGHT, matrixStack, renderTypeBuffer);
            }
        });
    }
}
