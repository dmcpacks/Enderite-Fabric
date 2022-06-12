package com.dmcpacks.enderite.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class OrePlacedFeature {
    public static final RegistryEntry<PlacedFeature> ORE_ENDERITE;

    static {
        ORE_ENDERITE = PlacedFeatures.register("ore_enderite", OreConfiguredFeature.ORE_ENDERITE, modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.aboveBottom(20), YOffset.fixed(50)) ));
    }

    public static void init() {
        RegistryKey<PlacedFeature> oreEnderite = ORE_ENDERITE.getKey().get();

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, oreEnderite);
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

}
