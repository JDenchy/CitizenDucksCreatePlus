package com.citizenduck.createplus.fluid;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import com.citizenduck.createplus.block.ModBlocks;
import com.citizenduck.createplus.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, CitizenDucksCreatePlus.MOD_ID);

    public static final Supplier<FlowingFluid> SOURCE_SYRUP = FLUIDS.register("source_syrup",
            () -> new BaseFlowingFluid.Source(ModFluids.SYRUP_PROPERTIES));

    public static final Supplier<FlowingFluid> FLOWING_SYRUP = FLUIDS.register("flowing_syrup",
            () -> new BaseFlowingFluid.Flowing(ModFluids.SYRUP_PROPERTIES));

    public static final DeferredBlock<LiquidBlock> SYRUP_BLOCK = ModBlocks.BLOCKS.register("syrup_block",
            () -> new LiquidBlock(ModFluids.SOURCE_SYRUP.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));

    public static final DeferredItem<Item> SYRUP_BUCKET = ModItems.ITEMS.registerItem("syrup_bucket",
        properties -> new BucketItem(ModFluids.SOURCE_SYRUP.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final BaseFlowingFluid.Properties SYRUP_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.SYRUP_FLUID_TYPE, SOURCE_SYRUP, FLOWING_SYRUP)
            .slopeFindDistance(2).levelDecreasePerBlock(1).tickRate(8)
            .block(ModFluids.SYRUP_BLOCK).bucket(ModFluids.SYRUP_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
