package com.dmcpacks.enderite.item;

import com.dmcpacks.enderite.Enderite;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup ENDERITE;

    public static void registerItemGroup() {
        ENDERITE = FabricItemGroup.builder(new Identifier(Enderite.MOD_ID, "dirtmonds"))
                .displayName(Text.translatable("itemGroup.enderite.enderite"))
                .icon(() -> new ItemStack(ModItems.ENDERITE_INGOT)).build();
    }
}
