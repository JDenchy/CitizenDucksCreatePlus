package com.citizenduck.createplus.block;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import com.citizenduck.createplus.item.ModItems;
import com.citizenduck.createplus.sound.ModSounds;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    //Create DeferredRegister for Mod Blocks
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CitizenDucksCreatePlus.MOD_ID);

    //Create and register Mod Block
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        //Registers the item for the block
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //Create new item for the Mod Block
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    //Create event method for Mod Blocks
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
