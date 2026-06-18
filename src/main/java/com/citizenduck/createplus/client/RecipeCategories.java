package com.citizenduck.createplus.client;

import com.citizenduck.createplus.recipe.ModRecipeTypes;
import com.citizenduck.createplus.recipe.OvenRecipe;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.inventory.RecipeBookType;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;

public class RecipeCategories
{
    public static RecipeBookCategories BAKING_SEARCH = RecipeBookCategories.valueOf("CITIZENDUCKSCREATEPLUS_BAKING_SEARCH");
    public static RecipeBookCategories BAKING_MEALS = RecipeBookCategories.valueOf("CITIZENDUCKSCREATEPLUS_BAKING_MEALS");
    public static RecipeBookCategories BAKING_SNACKS = RecipeBookCategories.valueOf("CITIZENDUCKSCREATEPLUS_BAKING_SNACKS");
    public static RecipeBookCategories BAKING_MISC = RecipeBookCategories.valueOf("CITIZENDUCKSCREATEPLUS_BAKING_MISC");

    public static void init(RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(RecipeBookType.valueOf("CITIZENDUCKSCREATEPLUS_BAKING"), ImmutableList.of(BAKING_SEARCH, BAKING_MEALS, BAKING_SNACKS, BAKING_MISC));
        event.registerAggregateCategory(BAKING_SEARCH, ImmutableList.of(BAKING_MEALS, BAKING_SNACKS, BAKING_MISC));
        event.registerRecipeCategoryFinder(ModRecipeTypes.BAKING.get(), recipe ->
        {
            if (recipe.value() instanceof OvenRecipe cookingRecipe) {
                OvenRecipeBookTab tab = cookingRecipe.getRecipeBookTab();
                if (tab != null) {
                    return switch (tab) {
                        case MEALS -> BAKING_MEALS;
                        case SNACKS -> BAKING_SNACKS;
                        case MISC -> BAKING_MISC;
                    };
                }
            }
            return BAKING_MISC;
        });
    }
}
