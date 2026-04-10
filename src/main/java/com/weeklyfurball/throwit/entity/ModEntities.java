package com.weeklyfurball.throwit.entity;

import com.weeklyfurball.throwit.ThrowIt;
import com.weeklyfurball.throwit.entity.custom.GodboltProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ThrowIt.MOD_ID);

    public static final RegistryObject<EntityType<GodboltProjectileEntity>> GODBOLT = ENTITY_TYPES.register("godbolt_projectile", () -> EntityType.Builder.of(GodboltProjectileEntity::new,
            MobCategory.MISC).sized(0.5f,0.5f).build("godbolt_projectile"));
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }


}
