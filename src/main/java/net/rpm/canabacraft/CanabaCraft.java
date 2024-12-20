package net.rpm.canabacraft;

import net.fabricmc.api.ModInitializer;


import net.minecraft.block.ComposterBlock;
import net.rpm.canabacraft.block.ModBlocks;
import net.rpm.canabacraft.item.ModItems;
import net.rpm.canabacraft.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CanabaCraft implements ModInitializer {
	public static final String MOD_ID = "canabacraft";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerModGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.HEMP_SEEDS, 0.3F);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BUD, 0.5F);

		ModLootTableModifiers.modifyLootTables();
	}
}