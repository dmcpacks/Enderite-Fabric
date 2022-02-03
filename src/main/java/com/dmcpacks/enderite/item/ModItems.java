package com.dmcpacks.enderite.item;

import com.dmcpacks.enderite.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import com.dmcpacks.enderite.Enderite;

public class ModItems {

    public static final Item ENDERITE_SCRAP = registerItem("enderite_scrap", new Item(new FabricItemSettings()
            .group(ModItemGroup.ENDERITE)));

    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot", new Item(new FabricItemSettings()
            .group(ModItemGroup.ENDERITE)));

    public static final Item ENDERITE_SWORD = registerItem("enderite_sword", new SwordItem(ModToolMaterial.ENDERITE, 4, -2.4f,
            new FabricItemSettings()
            .group(ModItemGroup.ENDERITE).maxDamage(1)));

    public static final Item ENDERITE_SHOVEL = registerItem("enderite_shovel", new ShovelItem(ModToolMaterial.ENDERITE, 0, -2.9f,
            new FabricItemSettings()
            .group(ModItemGroup.ENDERITE)));

    public static final Item ENDERITE_AXE = registerItem("enderite_axe", new ModAxeItem(ModToolMaterial.ENDERITE, 5f, -2.9f,
            new FabricItemSettings()
            .group(ModItemGroup.ENDERITE)));

    public static final Item ENDERITE_PICKAXE = registerItem("enderite_pickaxe", new ModPickaxeItem(ModToolMaterial.ENDERITE, 1, -2.8f,
            new FabricItemSettings()
            .group(ModItemGroup.ENDERITE)));

    public static final Item ENDERITE_HOE = registerItem("enderite_hoe", new ModHoeItem(ModToolMaterial.ENDERITE, 0, -1f,
            new FabricItemSettings()
            .group(ModItemGroup.ENDERITE)));

    public static final Item ENDERITE_HELMET = registerItem("enderite_helmet", new ModArmorItem(ModArmorMaterial.ENDERITE_ARMOR, EquipmentSlot.HEAD,
            new FabricItemSettings()
            .group(ModItemGroup.ENDERITE)));

    public static final Item ENDERITE_CHESTPLATE = registerItem("enderite_chestplate", new ModArmorItem(ModArmorMaterial.ENDERITE_ARMOR, EquipmentSlot.CHEST,
            new FabricItemSettings()
            .group(ModItemGroup.ENDERITE)));

    public static final Item ENDERITE_LEGGINGS = registerItem("enderite_leggings", new ModArmorItem(ModArmorMaterial.ENDERITE_ARMOR, EquipmentSlot.LEGS,
            new FabricItemSettings()
            .group(ModItemGroup.ENDERITE)));

    public static final Item ENDERITE_BOOTS = registerItem("enderite_boots", new ModArmorItem(ModArmorMaterial.ENDERITE_ARMOR, EquipmentSlot.FEET,
            new FabricItemSettings()
            .group(ModItemGroup.ENDERITE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Enderite.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering mod items");
    }
}
