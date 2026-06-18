package com.citizenduck.createplus.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredRegister;
import com.citizenduck.createplus.CitizenDucksCreatePlus;
import com.citizenduck.createplus.recipe.OvenRecipe;

import java.util.function.Supplier;

public class ModRecipeTypes
{
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, CitizenDucksCreatePlus.MOD_ID);

    public static final Supplier<RecipeType<OvenRecipe>> BAKING = RECIPE_TYPES.register("baking", () -> registerRecipeType("cooking"));

    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        return new RecipeType<>()
        {
            public String toString() {
                return CitizenDucksCreatePlus.MOD_ID + ":" + identifier;
            }
        };
    }
}
