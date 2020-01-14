package com.divinegenesis.otherworld.common.helpers;

import net.minecraftforge.fml.InterModComms;
import top.theillusivec4.curios.api.CuriosAPI;
import top.theillusivec4.curios.api.imc.CurioIMCMessage;

public class CuriosHelper
{
    public static void registerCuriosStuff()
    {
        registerType("head");
        registerType("necklace");
        registerType("body");
        registerType("feet");
    }

    private static void registerType(String name)
    {
        InterModComms.sendTo("curios", CuriosAPI.IMC.REGISTER_TYPE, () -> new CurioIMCMessage(name).setEnabled(true).setSize(1).setHidden(false));
    }
}
