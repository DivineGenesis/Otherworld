package com.divinegenesis.otherworld;

import com.divinegenesis.otherworld.common.fluid.ModFluids;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.CuriosAPI;
import top.theillusivec4.curios.api.imc.CurioIMCMessage;

@Mod(value = Otherworld.MODID)
public class Otherworld
{
    public static final String MODID = "otherworld";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Otherworld()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);

        MinecraftForge.EVENT_BUS.register(this);
        ModFluids fluids = new ModFluids();
    }

    private void onCommonSetup(final FMLCommonSetupEvent event){}

    private void onClientSetup(final FMLClientSetupEvent event){}

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("curios", CuriosAPI.IMC.REGISTER_TYPE, () -> new CurioIMCMessage("accessories").setEnabled(true).setSize(4).setHidden(false));
    }

    private void processIMC(final InterModProcessEvent event) {}
}