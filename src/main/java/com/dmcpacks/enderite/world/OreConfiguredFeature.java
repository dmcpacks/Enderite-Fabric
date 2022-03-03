package com.dmcpacks.enderite.world;

import com.dmcpacks.enderite.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class OreConfiguredFeature {

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_ENDERITE;

    static {
        ORE_ENDERITE = ConfiguredFeatures.register("ore_enderite", Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDERITE_DEBRIS.getDefaultState())), 7));
    }

}