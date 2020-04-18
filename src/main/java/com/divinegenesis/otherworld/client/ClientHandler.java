package com.divinegenesis.otherworld.client;

import com.divinegenesis.otherworld.client.renderer.HungryChestRenderer;
import com.divinegenesis.otherworld.client.renderer.entity.MandrakeRenderer;
import com.divinegenesis.otherworld.client.screens.SoulForgeScreen;
import com.divinegenesis.otherworld.common.containers.ModContainers;
import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.ModTileEntities;
import com.divinegenesis.otherworld.common.objects.entities.ModEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.BlockItem;
import net.minecraft.world.FoliageColors;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientHandler {

    public static void register() {
        ScreenManager.registerFactory(ModContainers.SOULFORGE_CONTAINER.get(), SoulForgeScreen::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.HUNGRY_CHEST, HungryChestRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MANDRAKE, MandrakeRenderer::new);

        //block foliage
        Minecraft.getInstance().getBlockColors().register((blockState, iLightReader, blockPos, i) ->
                FoliageColors.getDefault(), ModBlocks.GREATWOOD_LEAVES);

        Minecraft.getInstance().getItemColors().register((itemStack, i) ->
                Minecraft.getInstance().getBlockColors().getColor( ((BlockItem) itemStack.getItem()).getBlock().getDefaultState(), null, null, i),
                ModBlocks.GREATWOOD_LEAVES);


    }
}
