package com.dmcpacks.enderite.util;

import com.dmcpacks.enderite.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.Random;

public class ModLootTableModifiers {
    private static final Identifier END_CITY_TREASURE_ID
            = new Identifier("minecraft", "chests/end_city_treasure");

    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            //check for leaves loot table.
            if(END_CITY_TREASURE_ID.equals(id)) {
                // Adds enderite scrap to the end_city loot table.
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(.25f))
                        .with(ItemEntry.builder(ModItems.ENDERITE_SCRAP))
                        .build();
                supplier.pool(poolBuilder);
            }
        }));
    }
}
