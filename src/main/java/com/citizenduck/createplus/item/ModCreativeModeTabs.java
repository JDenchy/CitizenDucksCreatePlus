package com.citizenduck.createplus.item;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import com.citizenduck.createplus.block.ModBlocks;
import com.citizenduck.createplus.fluid.ModFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    //Construct Creative Mode Tab
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CitizenDucksCreatePlus.MOD_ID);

    //Assigns parameters to Creative Mode Tab
    public static final Supplier<CreativeModeTab> CITIZENDUCKS_CREATE_PLUS_TAB = CREATIVE_MODE_TAB.register("citizenducks_create_plus_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SUBHUMAN_MUSIC_DISC.get()))
                    .title(Component.translatable("creativetab.citizenduckscreateplus.citizenduckscreateplus"))
                    .displayItems((itemDisplayParameters, output) -> {
                      //List items that should be assigned to Creative Mode Tab
                        output.accept(ModItems.SUBHUMAN_MUSIC_DISC);
                        output.accept(ModItems.COOKIE_DOUGH);
                        output.accept(ModFluids.SYRUP_BUCKET);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
