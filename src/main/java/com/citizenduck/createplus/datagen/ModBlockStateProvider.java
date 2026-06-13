package com.citizenduck.createplus.datagen;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import com.citizenduck.createplus.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CitizenDucksCreatePlus.MOD_ID,exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
