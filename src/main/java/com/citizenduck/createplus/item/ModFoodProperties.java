package com.citizenduck.createplus.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    //Assign properties to custom item
    public static final FoodProperties COOKIE_DOUGH = new FoodProperties.Builder().nutrition(1).saturationModifier(0f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200), 0.20f).build();

    public static final FoodProperties ICING_JAR = new FoodProperties.Builder().nutrition(0).saturationModifier(0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100), 0.05f).build();

    public static final FoodProperties CHEESECAKE_FILLING = new FoodProperties.Builder().nutrition(1).saturationModifier(0f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200), 0.20f).build();

    public static final FoodProperties PLAIN_SWEET_ROLL = new FoodProperties.Builder().nutrition(1).saturationModifier(0f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 200), 0f).build();
}