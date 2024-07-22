package com.dmcpacks.enderite.block;

import com.dmcpacks.enderite.Enderite;
import com.dmcpacks.enderite.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class ModBlocks {

    public static final Block ENDERITE_DEBRIS = registerBlock("enderite_debris", new Block(FabricBlockSettings
            .of(Material.METAL)
            .requiresTool()
            .strength(100f, 30f)
            .sounds(BlockSoundGroup.ANCIENT_DEBRIS)));

    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block", new Block(FabricBlockSettings
            .of(Material.METAL)
            .requiresTool()
            .strength(40f, 35f)
            .sounds(BlockSoundGroup.NETHERITE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Enderite.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Enderite.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.ENDERITE).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        System.out.println("Registering blocks");
    }
}
