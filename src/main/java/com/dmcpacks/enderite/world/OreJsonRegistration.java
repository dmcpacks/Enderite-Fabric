package com.dmcpacks.enderite.world;

import com.dmcpacks.enderite.Enderite;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class OreJsonRegistration {
    public static final RegistryKey<PlacedFeature> ENDERITE_SMALL_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Enderite.MOD_ID,"enderite_ore_small"));
    public static final RegistryKey<PlacedFeature> ENDERITE_MEDIUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Enderite.MOD_ID,"enderite_ore_medium"));

    public static void registerOreGeneration() {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, ENDERITE_SMALL_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, ENDERITE_MEDIUM_ORE_PLACED_KEY);
        System.out.println("Registered ore generation");
    }
}
