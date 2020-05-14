package com.divinegenesis.otherworld.common;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class Config
{
    public static ForgeConfigSpec CLIENT_CONFIG;
    public static ForgeConfigSpec COMMON_CONFIG;

    static {
        CLIENT_CONFIG = new ForgeConfigSpec.Builder().configure(Client::new).getValue();
        COMMON_CONFIG = new ForgeConfigSpec.Builder().configure(Common::new).getValue();
    }

    public static class Client
    {
        public static ForgeConfigSpec.BooleanValue HEART_OVERLAY;

        public Client(ForgeConfigSpec.Builder builder)
        {
            builder.push("CLIENT");
            HEART_OVERLAY = builder.define("heart overlay", true);
            builder.pop();
            CLIENT_CONFIG = builder.build();
        }
    }

    public static class Common
    {
        public static ForgeConfigSpec.IntValue INSANITY_FROM_DARKNESS;

        public Common(ForgeConfigSpec.Builder builder)
        {
            builder.push("COMMON");

            INSANITY_FROM_DARKNESS = builder.comment("Insanity gained by being in the darkness")
                    .defineInRange("darkness insanity", 2, 0, 10);

            builder.pop();
            COMMON_CONFIG = builder.build();
        }
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path)
    {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }
}
