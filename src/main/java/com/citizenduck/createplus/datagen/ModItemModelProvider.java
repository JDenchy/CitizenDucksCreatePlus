package com.citizenduck.createplus.datagen;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import com.citizenduck.createplus.fluid.ModFluids;
import com.citizenduck.createplus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CitizenDucksCreatePlus.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.COOKIE_DOUGH.get());
        basicItem(ModFluids.SYRUP_BUCKET.get());
        basicItem(ModItems.SUBHUMAN_MUSIC_DISC.get());
    }
}