package net.rpm.canabacraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rpm.canabacraft.CanabaCraft;
import net.rpm.canabacraft.item.custom.JointItem;

public class ModItems {

    //List of mod items to register
    public static final Item BUD = registerItem("bud", new Item(new Item.Settings()));
    public static final Item SKIN = registerItem("skin", new Item(new Item.Settings()));
    public static final Item JOINT = registerItem("joint", new JointItem(new Item.Settings()));


    // Helper function that is used to register the mod items
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CanabaCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CanabaCraft.LOGGER.info("Registering Mod Items for " + CanabaCraft.MOD_ID);

        // add items to the FOOD and DRINK creative tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
           entries.add(BUD);
           entries.add(SKIN);
        });
    }
}
