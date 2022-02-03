package com.dmcpacks.enderite.item;

import com.dmcpacks.enderite.Enderite;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup ENDERITE = FabricItemGroupBuilder.build(new Identifier(Enderite.MOD_ID, "enderite"),
            () -> new ItemStack(ModItems.ENDERITE_SCRAP));
}
