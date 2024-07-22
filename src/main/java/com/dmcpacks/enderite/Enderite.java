package com.dmcpacks.enderite;

import com.dmcpacks.enderite.block.ModBlocks;
import com.dmcpacks.enderite.config.ModConfigs;
import com.dmcpacks.enderite.item.ModItemGroup;
import com.dmcpacks.enderite.item.ModItems;
import com.dmcpacks.enderite.util.ModLootTableModifiers;
import com.dmcpacks.enderite.world.OreJsonRegistration;
import net.fabricmc.api.ModInitializer;

public class Enderite implements ModInitializer {

	public static final String MOD_ID = "enderite";

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();
		ModItemGroup.registerItemGroup();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		OreJsonRegistration.registerOreGeneration();

		System.out.println("Fully registered " + MOD_ID);
	}
}
