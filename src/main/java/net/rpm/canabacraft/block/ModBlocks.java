package net.rpm.canabacraft.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.rpm.canabacraft.CanabaCraft;
import net.minecraft.util.Identifier;
import net.rpm.canabacraft.block.custom.HempCropBlock;

public class ModBlocks {
    //list of blocks to register
    public static final Block KILO_BUD_BLOCK = registerBlock("kilo_bud_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.GREEN)
                    .instrument(NoteBlockInstrument.BANJO)
                    .strength(0.5F)
                    .sounds(BlockSoundGroup.GRASS)
            ));

    public static final Block HEMP_CROP = Registry.register(Registries.BLOCK, Identifier.of(CanabaCraft.MOD_ID, "hemp_crop"),
            new HempCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));



    //-------------------------------------------------------
    // following functions register the blocks and block items
    //------------------------------------------------------
    // helper function to register mod blocks
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CanabaCraft.MOD_ID, name), block);
    }
    // helper function that is used to register modblock's item
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(CanabaCraft.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks() {
        CanabaCraft.LOGGER.info("Registering Mod Blocks for " + CanabaCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.KILO_BUD_BLOCK);
        });
    }
}
