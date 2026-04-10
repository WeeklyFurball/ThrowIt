package com.weeklyfurball.throwit.item.custom;

import com.weeklyfurball.throwit.entity.custom.GodboltProjectileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class GodboltItem extends Item {
    public GodboltItem(Properties pProperties) {
        super(pProperties);
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(), 1.0F, 10);
    }

    @Override
    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack){ return UseAnim.SPEAR; }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand){
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                SoundEvents.BEACON_ACTIVATE, SoundSource.NEUTRAL);
        if (!pLevel.isClientSide){
            GodboltProjectileEntity godboltProjectile = new GodboltProjectileEntity(pPlayer, pLevel);
            godboltProjectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 0F);
            pLevel.addFreshEntity(godboltProjectile);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponent, TooltipFlag pTooltipFlag){
        pTooltipComponent.add(Component.translatable("tooltip.throwit.godbolt.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponent, pTooltipFlag);
    }



}
