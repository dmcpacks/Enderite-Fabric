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
    public static final RegistryEntry<PlacedFeature> ORE_ENDERITE_LARGE;
    public static final RegistryEntry<PlacedFeature> ORE_ENDERITE_SMALL;

    static {
        ORE_ENDERITE_LARGE = PlacedFeatures.register("ore_enderite_large", OreConfiguredFeature.ORE_ENDERITE_LARGE, modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.aboveBottom(20), YOffset.fixed(40)) ));
        ORE_ENDERITE_SMALL = PlacedFeatures.register("ore_enderite_small", OreConfiguredFeature.ORE_ENDERITE_SMALL, modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.aboveBottom(20), YOffset.fixed(40)) ));
    }

    public static void init() {
        RegistryKey<PlacedFeature> oreEnderiteLarge = ORE_ENDERITE_LARGE.getKey().get();
        RegistryKey<PlacedFeature> oreEnderiteSmall = ORE_ENDERITE_SMALL.getKey().get();

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, oreEnderiteLarge);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, oreEnderiteSmall);
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

}
