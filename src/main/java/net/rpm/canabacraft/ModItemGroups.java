package net.rpm.canabacraft;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rpm.canabacraft.block.ModBlocks;
import net.rpm.canabacraft.item.ModItems;

public class ModItemGroups {

    public static final ItemGroup BUD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CanabaCraft.MOD_ID, "bud_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.BUD))
                    .displayName(Text.translatable("itemgroup.canabacraft.bud_items")) // choose icon
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BUD);
                        entries.add(ModItems.SKIN);
                        entries.add(ModBlocks.KILO_BUD_BLOCK);
                    }).build());


    public static void registerModGroups() {
        CanabaCraft.LOGGER.info("Registering Mod Groups for " + CanabaCraft.MOD_ID);
    }
}
