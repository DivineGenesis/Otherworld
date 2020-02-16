package com.divinegenesis.otherworld.common;

import com.divinegenesis.otherworld.Otherworld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModSounds
{
    private static final List<SoundEvent> SOUNDS = new ArrayList<SoundEvent>();
    public static final SoundEvent CRYSTAL_HEART = register("crystal_heart");

    private static SoundEvent register(String key)
    {
        SoundEvent s = new SoundEvent(new ResourceLocation("otherworld:" +key)).setRegistryName(key);
        SOUNDS.add(s);
        return s;
    }

    @SubscribeEvent
    public static void OnSoundRegistry(final RegistryEvent.Register<SoundEvent> event)
    {
        Otherworld.LOGGER.info("Some Smoooooth Jazz activated");
        SOUNDS.forEach(soundEvent -> event.getRegistry().register(soundEvent));
    }
}
