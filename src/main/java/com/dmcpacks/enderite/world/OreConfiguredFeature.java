package com.dmcpacks.enderite.world;

import com.dmcpacks.enderite.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class OreConfiguredFeature {

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_ENDERITE_LARGE;
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_ENDERITE_SMALL;

    static {
        ORE_ENDERITE_LARGE = ConfiguredFeatures.register("ore_enderite_large", Feature.SCATTERED_ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDERITE_DEBRIS.getDefaultState())), 3, 1.0F));
        ORE_ENDERITE_SMALL = ConfiguredFeatures.register("ore_enderite_small", Feature.SCATTERED_ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDERITE_DEBRIS.getDefaultState())), 2, 1.0F));
    }

}