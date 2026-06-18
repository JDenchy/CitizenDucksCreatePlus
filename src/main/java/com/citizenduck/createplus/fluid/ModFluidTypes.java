package com.citizenduck.createplus.fluid;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class ModFluidTypes {
    public static final ResourceLocation SYRUP_STILL_RL = ResourceLocation.fromNamespaceAndPath(CitizenDucksCreatePlus.MOD_ID,"block/syrup_still");
    public static final ResourceLocation SYRUP_FLOWING_RL = ResourceLocation.fromNamespaceAndPath(CitizenDucksCreatePlus.MOD_ID,"block/syrup_flow");
    public static final ResourceLocation SYRUP_OVERLAY_RL = ResourceLocation.parse("block/water_overlay");

    public static final ResourceLocation ICING_STILL_RL = ResourceLocation.fromNamespaceAndPath(CitizenDucksCreatePlus.MOD_ID,"block/icing_still");
    public static final ResourceLocation ICING_FLOWING_RL = ResourceLocation.fromNamespaceAndPath(CitizenDucksCreatePlus.MOD_ID,"block/icing_flow");
    public static final ResourceLocation ICING_OVERLAY_RL = ResourceLocation.parse("block/water_overlay");

    public static final ResourceLocation SEED_OIL_STILL_RL = ResourceLocation.parse("block/water_still");
    public static final ResourceLocation SEED_OIL_FLOWING_RL = ResourceLocation.parse("block/water_flow");
    public static final ResourceLocation SEED_OIL_OVERLAY_RL = ResourceLocation.parse("block/water_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, CitizenDucksCreatePlus.MOD_ID);

    public static final Supplier<FluidType> SYRUP_FLUID_TYPE = registerFluidType("syrup",
            new BaseFluidType(SYRUP_STILL_RL, SYRUP_FLOWING_RL, SYRUP_OVERLAY_RL, 0xdf6E4013,
                    new Vector3f(110f/255f, 64f/255f, 19f/255f),
                    FluidType.Properties.create()));

    public static final Supplier<FluidType> ICING_FLUID_TYPE = registerFluidType("icing",
            new BaseFluidType(ICING_STILL_RL, ICING_FLOWING_RL, ICING_OVERLAY_RL, 0xfffcf6ec,
                    new Vector3f(252f/255f, 238f/255f, 215f/255f),
                    FluidType.Properties.create()));

    public static final Supplier<FluidType> SEED_OIL_FLUID_TYPE = registerFluidType("seed_oil",
            new BaseFluidType(SEED_OIL_STILL_RL, SEED_OIL_FLOWING_RL, SEED_OIL_OVERLAY_RL, 0xffffe01e,
                    new Vector3f(255f/255f, 224f/255f, 30f/255f),
                    FluidType.Properties.create()));

    private static Supplier<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}