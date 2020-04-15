package com.divinegenesis.otherworld.client;

import com.divinegenesis.otherworld.client.renderer.HungryChestRenderer;
import com.divinegenesis.otherworld.client.renderer.entity.MandrakeRenderer;
import com.divinegenesis.otherworld.client.screens.SoulForgeScreen;
import com.divinegenesis.otherworld.common.containers.ModContainers;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.ModTileEntities;
import com.divinegenesis.otherworld.common.objects.entities.ModEntities;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientHandler {

    public static void register()
    {
        ScreenManager.registerFactory(ModContainers.SOULFORGE_CONTAINER.get(), SoulForgeScreen::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.HUNGRY_CHEST, HungryChestRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MANDRAKE, MandrakeRenderer::new);
    }
}
