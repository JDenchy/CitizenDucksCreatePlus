package com.citizenduck.createplus.sound;

import com.citizenduck.createplus.CitizenDucksCreatePlus;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, CitizenDucksCreatePlus.MOD_ID);
    //registers generic sound
    public static final Supplier<SoundEvent> SUBHUMAN = registerSoundEvent("subhuman");
    //registers Subhuman Jukebox song
    public static final ResourceKey<JukeboxSong> SUBHUMAN_KEY = createSong("subhuman");

    //creates Jukebox song
    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(CitizenDucksCreatePlus.MOD_ID, name));
    }

    //public static final Supplier<SoundEvent> BLOCK_OVEN_CRACKLE = registerSoundEvent("block_oven_crackle");

    public static final Supplier<SoundEvent> BLOCK_OVEN_CRACKLE = SOUND_EVENTS.register("block.oven.crackle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(CitizenDucksCreatePlus.MOD_ID, "block.stove.crackle")));

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(CitizenDucksCreatePlus.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
