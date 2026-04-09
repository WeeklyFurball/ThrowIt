package com.weeklyfurball.throwit.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class IronLumpItem extends Item {
    public static final int THROW_THRESHOLD_TIME = 3;
    public static final float BASE_DAMAGE = 3.0f;
    public static final float SHOOT_POWER = 4.0f;

    public IronLumpItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponent, TooltipFlag pTooltipFlag){
        pTooltipComponent.add(Component.translatable("tooltip.throwit.ironlump.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponent, pTooltipFlag);
    }
}
