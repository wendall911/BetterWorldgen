package betterworldgen;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;

@Mod(BetterWorldgen.MODID)
public class BetterWorldgenForge {

    public BetterWorldgenForge() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BetterWorldgen.init();
        registryInit();
    }

    private void registryInit() {
    }

    private static <T> void bind(ResourceKey<Registry<T>> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
        FMLJavaModLoadingContext.get().getModEventBus().addListener((RegisterEvent event) -> {
            if (registry.equals(event.getRegistryKey())) {
                source.accept((t, rl) -> event.register(registry, rl, () -> t));
            }
        });
    }

}