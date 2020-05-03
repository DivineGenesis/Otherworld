package com.divinegenesis.otherworld.common.objects.items.types;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.capability.curios.CuriosItemCapability;
import com.divinegenesis.otherworld.common.capability.curios.IOWCurio;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Quaternion;
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

    private int maxFlightTime = 80;
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
            private int flight = maxFlightTime; // seconds*20 ticks
            private boolean in = true;
            private boolean flying;
            private float degrees = 33.3f;

            @Override
            public void onCurioTick(String identifier, int index, LivingEntity livingEntity)
            {
                if (livingEntity instanceof PlayerEntity)
                {
                    PlayerEntity player = (PlayerEntity) livingEntity;
                    boolean isJumping = ObfuscationReflectionHelper.getPrivateValue(LivingEntity.class, livingEntity, "isJumping");

                    if (!player.onGround && isJumping)
                    {
                        flying = true;
                        Vec3d vec = player.getMotion();
                        double x = vec.x;
                        double y = vec.y;
                        double z = vec.z;

                        if(flight > 0) {
                            x*= 1.08;
                            z*= 1.08;
                            y = y + 0.095D;
                            flight--;
                        }
                        else
                        {
                            if(y < -0.15D)
                                y += 0.096D;
                        }
                        player.setMotion(new Vec3d(x, y, z));
                    }
                    else if(player.onGround) {
                        flight = maxFlightTime;
                        flying = false;
                    }
                }
            }

            @Override
            public boolean hasRender(String identifier, LivingEntity livingEntity) {
                return true;
            }

            //TODO: Higher res wings? Allows wings to be better scaled on player
            @Override
            public void render(String identifier, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch)
            {
                matrixStack.push();
                ICurio.RenderHelper.translateIfSneaking(matrixStack, livingEntity);
                ICurio.RenderHelper.rotateIfSneaking(matrixStack, livingEntity);
                matrixStack.translate(0d, 0d, 0.1d);
                matrixStack.rotate(Vector3f.ZP.rotationDegrees(180f));

                matrixStack.translate(0d, 0d, 0d);
                matrixStack.rotate(Vector3f.YP.rotationDegrees(degrees));
                matrixStack.translate(-0.5d, 0d, 0d);

                Minecraft.getInstance().getItemRenderer().renderItem(stack, ItemCameraTransforms.TransformType.NONE, light, OverlayTexture.DEFAULT_LIGHT, matrixStack, renderTypeBuffer);
                matrixStack.pop();

                matrixStack.push();
                ICurio.RenderHelper.translateIfSneaking(matrixStack, livingEntity);
                ICurio.RenderHelper.rotateIfSneaking(matrixStack, livingEntity);
                matrixStack.translate(0d, 0d, 0.1d);
                matrixStack.rotate(Vector3f.ZP.rotationDegrees(180f));

                matrixStack.translate(0d, 0d, 0d);
                matrixStack.rotate(Vector3f.YP.rotationDegrees(180 - degrees));
                matrixStack.translate(-0.5d, 0d, 0d);

                Minecraft.getInstance().getItemRenderer().renderItem(stack, ItemCameraTransforms.TransformType.NONE, light, OverlayTexture.DEFAULT_LIGHT, matrixStack, renderTypeBuffer);
                matrixStack.pop();

                if(in && degrees < 20f)
                    in = false;
                else if(!in && degrees > 60f)
                    in = true;

                if(flying) degrees = in ? degrees-.75f:degrees+.75f;
            }
        });
    }
}
