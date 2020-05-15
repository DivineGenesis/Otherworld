package com.divinegenesis.otherworld.common;

import com.divinegenesis.otherworld.Otherworld;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.commons.lang3.tuple.Pair;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config
{
    public static Client CLIENT;
    public static Common COMMON;

    private static ForgeConfigSpec CLIENT_CONFIG;
    private static ForgeConfigSpec COMMON_CONFIG;


    static {
        final Pair<Client, ForgeConfigSpec> clientPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT_CONFIG = clientPair.getRight();
        CLIENT = clientPair.getLeft();

        final Pair<Common, ForgeConfigSpec> commonPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_CONFIG = commonPair.getRight();
        COMMON = commonPair.getLeft();
    }

    public static void register()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        Config.loadConfig(CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve(Otherworld.MODID+"-client.toml"));

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        Config.loadConfig(COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(Otherworld.MODID+"-common.toml"));
        COMMON.updateMap();
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
        public static ForgeConfigSpec.DoubleValue INSANITY_FROM_DARKNESS;
        public static Map<String, Double> INSANITY_LIST;

        public Common(ForgeConfigSpec.Builder builder)
        {
            builder.push("COMMON");


            INSANITY_FROM_DARKNESS = builder.comment("Insanity gained by being in the darkness")
                    .defineInRange("darkness insanity", 2.0, 0, 10);

             list = builder.define("Insanity list", Arrays.asList("minecraft:grass;5"));


            builder.pop();
            COMMON_CONFIG = builder.build();
        }

        private static ForgeConfigSpec.ConfigValue<List<String>> list;
        public static void updateMap()
        {
            INSANITY_LIST = convertListToMap(list.get());
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

    private static Map<String, Double> convertListToMap(List<String> list)
    {
        Map<String, Double> map = new HashMap<String, Double>();

        list.forEach(o ->
        {
            String[] split = o.toString().split(";");

            String key = split[0];
            Double value = Double.parseDouble(split[1]);

            map.put(key, value);
        });
        return map;
    }
}
