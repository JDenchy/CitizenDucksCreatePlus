package com.citizenduck.createplus.registry;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import com.citizenduck.createplus.recipe.OvenRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.function.Supplier;

public class ModRecipeSerializers
{
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, CitizenDucksCreatePlus.MOD_ID);

    public static final Supplier<RecipeSerializer<?>> BAKING = RECIPE_SERIALIZERS.register("baking", OvenRecipe.Serializer::new);
}
