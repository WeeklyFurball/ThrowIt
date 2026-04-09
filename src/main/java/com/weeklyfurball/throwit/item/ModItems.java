package com.weeklyfurball.throwit.item;

import com.weeklyfurball.throwit.ThrowIt;
import com.weeklyfurball.throwit.item.custom.GodboltItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ThrowIt.MOD_ID);

    public static final RegistryObject<Item> GODBOLT = ITEMS.register("godbolt", () -> new GodboltItem(new Item.Properties().durability(1000)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
