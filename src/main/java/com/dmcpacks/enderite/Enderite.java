package com.dmcpacks.enderite;

import com.dmcpacks.enderite.block.ModBlocks;
import com.dmcpacks.enderite.config.ModConfigs;
import com.dmcpacks.enderite.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;

import static net.minecraft.block.Blocks.END_STONE;

public class Enderite implements ModInitializer {

	public static final String MOD_ID = "enderite";

	//ore spawning

	private static ConfiguredFeature<?, ?> END_ENDERITE_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					new BlockMatchRuleTest(END_STONE),
					ModBlocks.ENDERITE_DEBRIS.getDefaultState(),
					4)); // vein size

	public static PlacedFeature END_ENDERITE_ORE_PLACED_FEATURE = END_ENDERITE_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(1), // number of veins per chunk
			SquarePlacementModifier.of(), // spreading horizontally
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(50))); // height

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		//registering enderite
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("enderite", "end_enderite_ore"), END_ENDERITE_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("enderite", "end_enderite_ore"),
				END_ENDERITE_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("enderite", "end_enderite_ore")));

		System.out.print("Fully registered" + MOD_ID);
	}
}
