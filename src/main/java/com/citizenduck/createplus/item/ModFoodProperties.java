package com.citizenduck.createplus.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    //Assign properties to custom item
    public static final FoodProperties COOKIE_DOUGH = new FoodProperties.Builder().nutrition(1).saturationModifier(0f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200), 0.35f).build();
}