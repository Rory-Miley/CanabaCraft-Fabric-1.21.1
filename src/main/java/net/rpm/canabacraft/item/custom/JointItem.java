package net.rpm.canabacraft.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;


public class JointItem extends Item {

    public JointItem(Settings settings) {
        super(new Item.Settings().maxCount(1).maxDamage(12));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, net.minecraft.entity.player.PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!world.isClient) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 12000, 1)); // 12000 ticks = 10 minutes
            itemStack.setDamage(itemStack.getDamage() + 1);
            if (itemStack.getDamage() >= itemStack.getMaxDamage()) {
                itemStack.decrement(1);
            }
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

}
