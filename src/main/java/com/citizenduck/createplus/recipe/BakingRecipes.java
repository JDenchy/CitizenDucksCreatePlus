package com.citizenduck.createplus.recipe;

import com.citizenduck.createplus.item.ModItems;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.crafting.DifferenceIngredient;
import com.citizenduck.createplus.client.OvenRecipeBookTab;
import com.citizenduck.createplus.datagen.OvenRecipeBuilder;

public class BakingRecipes {
    
    public static final int FAST_BAKING = 100;      // 5 seconds
    public static final int NORMAL_BAKING = 200;    // 10 seconds
    public static final int SLOW_BAKING = 400;      // 20 seconds

    public static final float SMALL_EXP = 0.35F;
    public static final float MEDIUM_EXP = 1.0F;
    public static final float LARGE_EXP = 2.0F;

    public static void register(RecipeOutput output) {
        bakeCheesecake(output);
        bakeCookies(output);
        bakeMeals(output);
    }

    private static void bakeCheesecake(RecipeOutput output) {

    }

    private static void bakeCookies(RecipeOutput output) {
        OvenRecipeBuilder.bakingRecipe(Items.COOKIE, 8, FAST_BAKING, SMALL_EXP)
            .addIngredient(ModItems.COOKIE_DOUGH)
            .addIngredient(Items.COCOA_BEANS)
            .setRecipeBookTab(OvenRecipeBookTab.SNACKS)
            .saveToCDCP(output);
    }

        private static void bakeMeals(RecipeOutput output) {
    }
}
