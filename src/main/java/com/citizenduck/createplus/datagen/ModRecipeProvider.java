package com.citizenduck.createplus.datagen;

import com.citizenduck.createplus.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COOKIE_DOUGH.get(), 1)
                .requires(Items.SUGAR, 2)
                .requires(Items.WHEAT)
                .requires(Items.MILK_BUCKET)
                .requires(Items.EGG)
                .unlockedBy("has_cookie_dough", has(ModItems.COOKIE_DOUGH)).save(recipeOutput);
    }
}
