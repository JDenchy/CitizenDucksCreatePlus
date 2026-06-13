package com.citizenduck.createplus.datagen;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import com.citizenduck.createplus.fluid.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, CitizenDucksCreatePlus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(FluidTags.WATER)
                .add(ModFluids.SOURCE_SYRUP.get())
                .add(ModFluids.FLOWING_SYRUP.get());

        //Icing gets lava physics
        /*
        tag(FluidTags.LAVA)
                .add(ModFluids.SOURCE_ICING.get())
                .add(ModFluids.FLOWING_ICING.get());
         */
    }
}
