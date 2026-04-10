package com.weeklyfurball.throwit.entity.custom;

import com.weeklyfurball.throwit.entity.ModEntities;
import com.weeklyfurball.throwit.item.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;

public class GodboltProjectileEntity extends AbstractArrow {
    private float rotation;
    public Vec2 groundedOffset;

    public GodboltProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel){
        super(pEntityType, pLevel);
    }

    public GodboltProjectileEntity(LivingEntity shooter, Level level){
        super(ModEntities.GODBOLT.get(), shooter, level, new ItemStack(ModItems.GODBOLT.get()), null);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return null;
    }
}
