package com.citizenduck.createplus.block;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import com.citizenduck.createplus.block.custom.OvenBlock;
import com.citizenduck.createplus.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Function;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CitizenDucksCreatePlus.MOD_ID);

    public static final DeferredBlock<Block> OVEN = registerBlock("oven",
            () -> new OvenBlock(BlockBehaviour.Properties.of().strength(2).sound(SoundType.DEEPSLATE_BRICKS)));

    // Workstations
    /*
    public static final Supplier<Block> OVEN = BLOCKS.register("oven",
            () -> new OvenBlock(Block.Properties.ofFullCopy(Blocks.BRICKS).lightLevel(litBlockEmission(13))));
    */

    //block registry
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //registers Block Item at time of Block registry
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
