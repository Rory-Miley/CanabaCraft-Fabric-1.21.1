package net.rpm.canabacraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.rpm.canabacraft.block.ModBlocks;
import net.rpm.canabacraft.block.custom.HempCropBlock;
import net.rpm.canabacraft.item.ModItems;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    //public ModLootTableProvider(FabricDataOutput dataOutput) {super(dataOutput);}
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(dataOutput, registriesFuture);
    }

    @Override
    public void generate() {
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.HEMP_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(HempCropBlock.AGE, 5));
        addDrop(ModBlocks.HEMP_CROP, cropDrops(ModBlocks.HEMP_CROP, ModItems.BUD, ModItems.HEMP_SEEDS, builder));
    }
}