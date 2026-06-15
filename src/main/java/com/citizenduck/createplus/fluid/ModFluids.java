package com.citizenduck.createplus.fluid;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import com.citizenduck.createplus.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, CitizenDucksCreatePlus.MOD_ID);

    //register syrup liquids
    public static final Supplier<FlowingFluid> SOURCE_SYRUP = FLUIDS.register("syrup",
            () -> new BaseFlowingFluid.Source(ModFluids.SYRUP_PROPERTIES));

    public static final Supplier<FlowingFluid> FLOWING_SYRUP = FLUIDS.register("flowing_syrup",
            () -> new BaseFlowingFluid.Flowing(ModFluids.SYRUP_PROPERTIES));

    /*
    //register syrup block
    public static final DeferredBlock<LiquidBlock> SYRUP_BLOCK = ModBlocks.BLOCKS.register("syrup_block",
            () -> new LiquidBlock(ModFluids.SOURCE_SYRUP.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    */

    //register syrup bucket
    public static final DeferredItem<Item> SYRUP_BUCKET = ModItems.ITEMS.registerItem("syrup_bucket",
        properties -> new BucketItem(ModFluids.SOURCE_SYRUP.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));


    //create syrup properties
    public static final BaseFlowingFluid.Properties SYRUP_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.SYRUP_FLUID_TYPE, SOURCE_SYRUP, FLOWING_SYRUP)
            .slopeFindDistance(2).levelDecreasePerBlock(1).tickRate(8)
            //.block(ModFluids.SYRUP_BLOCK)
            .bucket(ModFluids.SYRUP_BUCKET);

    //register icing liquids
    public static final Supplier<FlowingFluid> SOURCE_ICING = FLUIDS.register("icing",
            () -> new BaseFlowingFluid.Source(ModFluids.ICING_PROPERTIES));

    public static final Supplier<FlowingFluid> FLOWING_ICING = FLUIDS.register("flowing_icing",
            () -> new BaseFlowingFluid.Flowing(ModFluids.ICING_PROPERTIES));

    /*
    //register icing block
    public static final DeferredBlock<LiquidBlock> ICING_BLOCK = ModBlocks.BLOCKS.register("icing_block",
            () -> new LiquidBlock(ModFluids.SOURCE_ICING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    */

    public static final DeferredItem<Item> ICING_BUCKET = ModItems.ITEMS.registerItem("icing_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_ICING.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));

    //create icing properties
    public static final BaseFlowingFluid.Properties ICING_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.ICING_FLUID_TYPE, SOURCE_ICING, FLOWING_ICING)
            .slopeFindDistance(2).levelDecreasePerBlock(1).tickRate(2)
            //.block(ModFluids.ICING_BLOCK)
            ;

    //register icing liquids
    public static final Supplier<FlowingFluid> SOURCE_SEED_OIL = FLUIDS.register("seed_oil",
            () -> new BaseFlowingFluid.Source(ModFluids.SEED_OIL_PROPERTIES));

    public static final Supplier<FlowingFluid> FLOWING_SEED_OIL = FLUIDS.register("flowing_seed_oil",
            () -> new BaseFlowingFluid.Flowing(ModFluids.SEED_OIL_PROPERTIES));

    /*
    //register icing block
    public static final DeferredBlock<LiquidBlock> ICING_BLOCK = ModBlocks.BLOCKS.register("icing_block",
            () -> new LiquidBlock(ModFluids.SOURCE_ICING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    */

    public static final DeferredItem<Item> SEED_OIL_BUCKET = ModItems.ITEMS.registerItem("seed_oil_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_SEED_OIL.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));

    //create icing properties
    public static final BaseFlowingFluid.Properties SEED_OIL_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.SEED_OIL_FLUID_TYPE, SOURCE_SEED_OIL, FLOWING_SEED_OIL)
            .slopeFindDistance(2).levelDecreasePerBlock(1).tickRate(2)
            //.block(ModFluids.ICING_BLOCK)
            ;

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}