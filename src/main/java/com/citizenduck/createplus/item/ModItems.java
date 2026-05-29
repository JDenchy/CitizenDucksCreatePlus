package com.citizenduck.createplus.item;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CitizenDucksCreatePlus.MOD_ID);

    public static final DeferredItem<Item> PANCAKEMIX = ITEMS.register("pancakemix",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}