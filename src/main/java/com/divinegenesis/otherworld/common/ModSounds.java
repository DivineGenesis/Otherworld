package com.divinegenesis.otherworld.common;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import java.util.ArrayList;
import java.util.List;

public class ModSounds
{
    public static final List<SoundEvent> SOUNDS = new ArrayList<SoundEvent>();

    private static SoundEvent register(String key)
    {
        SoundEvent s = new SoundEvent(new ResourceLocation("otherworld:" +key)).setRegistryName(key);
        SOUNDS.add(s);
        return s;
    }
}
