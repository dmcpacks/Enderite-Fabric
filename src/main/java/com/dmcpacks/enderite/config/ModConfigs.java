package com.dmcpacks.enderite.config;

import com.dmcpacks.enderite.Enderite;
import com.mojang.datafixers.util.Pair;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static boolean fullsetbonus;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(Enderite.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("fullsetbonus", true), "false to disable, true to enable");
    }

    private static void assignConfigs() {
        fullsetbonus = CONFIG.getOrDefault("fullsetbonus", true);
    }
}