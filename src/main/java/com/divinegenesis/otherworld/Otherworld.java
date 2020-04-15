package com.divinegenesis.otherworld;

import com.divinegenesis.otherworld.client.ClientHandler;
import com.divinegenesis.otherworld.client.renderer.HungryChestRenderer;
import com.divinegenesis.otherworld.client.screens.SoulForgeScreen;
import com.divinegenesis.otherworld.common.containers.ModContainers;
import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.capability.CapabilityOWPlayer;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.ModTileEntities;
import com.divinegenesis.otherworld.common.objects.entities.types.MandrakeEntity;
import com.divinegenesis.otherworld.common.objects.fluids.ModFluids;
import com.divinegenesis.otherworld.common.helpers.CuriosHelper;
import com.divinegenesis.otherworld.common.world.dimensions.ModDimUtil;
import com.divinegenesis.otherworld.common.world.gen.WorldGenManager;
import com.divinegenesis.otherworld.common.network.NetworkHandler;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value = Otherworld.MODID)
public class Otherworld
{
    public static final String MODID = "otherworld";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final ItemGroup OWTAB = new ItemGroup(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.HUNGRY_CHEST);
        }
    };

    public Otherworld()
    {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);

        MinecraftForge.EVENT_BUS.register(this);
        ModFluids fluids = new ModFluids();
        ModDimUtil.DIMENSIONS.register(event);
        ModContainers.CONTAINERS.register(event);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event)
    {
        NetworkHandler.register();
        WorldGenManager.setupGenerator();
        CapabilityOWPlayer.register();
    }

    private void onClientSetup(final FMLClientSetupEvent event)
    {
        ClientHandler.register();
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        CuriosHelper.registerCuriosStuff();
    }

    private void processIMC(final InterModProcessEvent event) {}
}