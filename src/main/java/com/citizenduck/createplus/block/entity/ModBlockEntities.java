package com.citizenduck.createplus.block.entity;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import com.citizenduck.createplus.block.ModBlocks;
import com.citizenduck.createplus.block.custom.OvenBlock;
import com.citizenduck.createplus.block.custom.PedestalBlock;
import com.citizenduck.createplus.block.entity.custom.OvenBlockEntity;
import com.citizenduck.createplus.block.entity.custom.PedestalBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CitizenDucksCreatePlus.MOD_ID);

    public static final Supplier<BlockEntityType<PedestalBlockEntity>> PEDESTAL_BE =
            BLOCK_ENTITIES.register("pedestal_be", () -> BlockEntityType.Builder.of(
                    PedestalBlockEntity::new, ModBlocks.PEDESTAL.get()).build(null));

    public static final Supplier<BlockEntityType<OvenBlockEntity>> OVEN_BE =
            BLOCK_ENTITIES.register("oven_be", () -> BlockEntityType.Builder.of(
                    OvenBlockEntity::new, ModBlocks.OVEN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
