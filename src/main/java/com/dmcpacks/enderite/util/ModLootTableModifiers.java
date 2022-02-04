package com.dmcpacks.enderite.util;

import com.dmcpacks.enderite.item.ModItems;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
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

        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            //check for leaves loot table.
            if(END_CITY_TREASURE_ID.equals(id)) {
                // Adds enderite scrap to the end_city loot table.
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.ENDERITE_SCRAP))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
        }));
    }
}
