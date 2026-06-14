package com.citizenduck.createplus.item;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import com.citizenduck.createplus.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    //Construct the custom item
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CitizenDucksCreatePlus.MOD_ID);

    //Assign properties to custom item
    public static final DeferredItem<Item> COOKIE_DOUGH = ITEMS.register("cookie_dough",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COOKIE_DOUGH)));

    public static final DeferredItem<Item> ICING_JAR = ITEMS.register("icing_jar",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ICING_JAR)));

    public static final DeferredItem<Item> CHEESECAKE_FILLING = ITEMS.register("cheesecake_filling",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHEESECAKE_FILLING)));

    public static final DeferredItem<Item> SUBHUMAN_MUSIC_DISC = ITEMS.register("subhuman_music_disc",
        () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.SUBHUMAN_KEY).stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}