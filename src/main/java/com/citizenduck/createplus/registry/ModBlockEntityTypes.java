package com.citizenduck.createplus.registry;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntityTypes
{
    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, CitizenDucksCreatePlus.MOD_ID);


}