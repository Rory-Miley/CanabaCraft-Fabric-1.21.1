package net.rpm.canabacraft.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GrinderItem extends Item {
    public GrinderItem(Settings settings) {
        super(new Item.Settings().maxCount(1).maxDamage(200));
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        // Damage the grinder instead of consuming it
        ItemStack copy = stack.copy();
        copy.setDamage(copy.getDamage() + 1);
        if (copy.getDamage() >= copy.getMaxDamage()) {
            copy.decrement(1);
            return ItemStack.EMPTY;
        }
        else{
            return copy;
        }
    }

    @Override
    public boolean hasRecipeRemainder() {
        return true;
    }
}
