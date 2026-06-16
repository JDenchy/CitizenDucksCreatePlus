package com.citizenduck.createplus;

import com.citizenduck.createplus.fluid.BaseFluidType;
import com.citizenduck.createplus.fluid.ModFluidTypes;
import com.citizenduck.createplus.fluid.ModFluids;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = CitizenDucksCreatePlus.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = CitizenDucksCreatePlus.MOD_ID, value = Dist.CLIENT)
public class CitizenDucksCreatePlusClient {

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SYRUP.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SYRUP.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_ICING.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_ICING.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SEED_OIL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SEED_OIL.get(), RenderType.translucent());
        });
    }

    @SubscribeEvent
    public static void onClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(((BaseFluidType) ModFluidTypes.SYRUP_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                ModFluidTypes.SYRUP_FLUID_TYPE.get());
        event.registerFluidType(((BaseFluidType) ModFluidTypes.ICING_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                ModFluidTypes.ICING_FLUID_TYPE.get());
        event.registerFluidType(((BaseFluidType) ModFluidTypes.SEED_OIL_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                ModFluidTypes.SEED_OIL_FLUID_TYPE.get());
    }
}

