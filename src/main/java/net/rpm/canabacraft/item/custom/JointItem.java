package net.rpm.canabacraft.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;


public class JointItem extends Item {

    public JointItem(Settings settings) {
        super(new Item.Settings().maxCount(1).maxDamage(12));
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 20; // 20 ticks = 1 second
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.setCurrentHand(hand);
        return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
    }

    public void applyEffect(LivingEntity user){
        if (user instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) user;
            // 3000 ticks = 2.5 minutes
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 3000, 1));
        }
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient) {
            applyEffect(user);
            stack.setDamage(stack.getDamage() + 1);
            if (stack.getDamage() >= stack.getMaxDamage()) {
                stack.decrement(1);
            }
        }
        return stack;
    }
}