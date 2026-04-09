package com.weeklyfurball.throwit.item.custom;

import net.minecraft.world.item.Item;

public class RockItem extends Item {
    public static final int THROW_THRESHOLD_TIME = 3;
    public static final float BASE_DAMAGE = 2.0f;
    public static final float SHOOT_POWER = 4.0f;

    public RockItem(Properties pProperties) {
        super(pProperties);
    }

}
