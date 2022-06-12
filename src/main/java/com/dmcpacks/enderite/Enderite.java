package com.dmcpacks.enderite;

import com.dmcpacks.enderite.block.ModBlocks;
import com.dmcpacks.enderite.config.ModConfigs;
import com.dmcpacks.enderite.item.ModItems;
import com.dmcpacks.enderite.util.ModLootTableModifiers;
import com.dmcpacks.enderite.world.OrePlacedFeature;
import net.fabricmc.api.ModInitializer;

public class Enderite implements ModInitializer {

	public static final String MOD_ID = "enderite";

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		OrePlacedFeature.init();

		System.out.print("Fully registered" + MOD_ID);
	}
}
