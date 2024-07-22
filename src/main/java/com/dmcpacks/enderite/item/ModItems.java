package com.dmcpacks.enderite.item;

import com.dmcpacks.enderite.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.dmcpacks.enderite.Enderite;

public class ModItems {

    public static final Item ENDERITE_SCRAP = registerItem("enderite_scrap", new Item(new FabricItemSettings()));

    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot", new Item(new FabricItemSettings()));

    public static final Item ENDERITE_SWORD = registerItem("enderite_sword", new SwordItem(ModToolMaterial.ENDERITE, 4, -2.4f,
            new FabricItemSettings()));

    public static final Item ENDERITE_SHOVEL = registerItem("enderite_shovel", new ShovelItem(ModToolMaterial.ENDERITE, 0, -2.9f,
            new FabricItemSettings()));

    public static final Item ENDERITE_AXE = registerItem("enderite_axe", new ModAxeItem(ModToolMaterial.ENDERITE, 5f, -2.9f,
            new FabricItemSettings()));

    public static final Item ENDERITE_PICKAXE = registerItem("enderite_pickaxe", new ModPickaxeItem(ModToolMaterial.ENDERITE, 1, -2.8f,
            new FabricItemSettings()));

    public static final Item ENDERITE_HOE = registerItem("enderite_hoe", new ModHoeItem(ModToolMaterial.ENDERITE, 0, -1f,
            new FabricItemSettings()));

    public static final Item ENDERITE_HELMET = registerItem("enderite_helmet", new ModArmorItem(ModArmorMaterial.ENDERITE_ARMOR, EquipmentSlot.HEAD,
            new FabricItemSettings()));

    public static final Item ENDERITE_CHESTPLATE = registerItem("enderite_chestplate", new ModArmorItem(ModArmorMaterial.ENDERITE_ARMOR, EquipmentSlot.CHEST,
            new FabricItemSettings()));

    public static final Item ENDERITE_LEGGINGS = registerItem("enderite_leggings", new ModArmorItem(ModArmorMaterial.ENDERITE_ARMOR, EquipmentSlot.LEGS,
            new FabricItemSettings()));

    public static final Item ENDERITE_BOOTS = registerItem("enderite_boots", new ModArmorItem(ModArmorMaterial.ENDERITE_ARMOR, EquipmentSlot.FEET,
            new FabricItemSettings()));

    public static void addItemsToItemGroups() {
        addToItemGroup(ModItemGroup.ENDERITE, ENDERITE_SCRAP);
        addToItemGroup(ModItemGroup.ENDERITE, ENDERITE_INGOT);
        addToItemGroup(ModItemGroup.ENDERITE, ENDERITE_SWORD);
        addToItemGroup(ModItemGroup.ENDERITE, ENDERITE_SHOVEL);
        addToItemGroup(ModItemGroup.ENDERITE, ENDERITE_AXE);
        addToItemGroup(ModItemGroup.ENDERITE, ENDERITE_PICKAXE);
        addToItemGroup(ModItemGroup.ENDERITE, ENDERITE_HOE);
        addToItemGroup(ModItemGroup.ENDERITE, ENDERITE_HELMET);
        addToItemGroup(ModItemGroup.ENDERITE, ENDERITE_CHESTPLATE);
        addToItemGroup(ModItemGroup.ENDERITE, ENDERITE_LEGGINGS);
        addToItemGroup(ModItemGroup.ENDERITE, ENDERITE_BOOTS);
    }

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Enderite.MOD_ID, name), item);
    }

    public static void registerModItems() {
        addItemsToItemGroups();
        System.out.println("Registered mod items");
    }
}
