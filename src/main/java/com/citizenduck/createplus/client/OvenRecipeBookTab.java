package com.citizenduck.createplus.client;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.util.StringRepresentable;

import java.util.EnumSet;
import org.jetbrains.annotations.NotNull;

public enum OvenRecipeBookTab implements StringRepresentable
{
    MEALS("meals"),
    SNACKS("snacks"),
    MISC("misc");

    public static final Codec<OvenRecipeBookTab> CODEC = Codec.STRING.flatXmap(s -> {
        OvenRecipeBookTab tab = findByName(s);
        if (tab == null) {
            return DataResult.error(() -> "Optional field 'recipe_book_tab' does not match any valid tab. If defined, must be one of the following: " + EnumSet.allOf(OvenRecipeBookTab.class));
        }
        return DataResult.success(tab);
    }, tab -> DataResult.success(tab.toString()));

    public final String name;

    OvenRecipeBookTab(String name) {
        this.name = name;
    }

    public static OvenRecipeBookTab findByName(String name) {
        for (OvenRecipeBookTab value : values()) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }
}