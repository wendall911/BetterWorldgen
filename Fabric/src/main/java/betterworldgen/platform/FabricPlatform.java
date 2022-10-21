package betterworldgen.platform;

import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import betterworldgen.platform.services.IPlatform;

public class FabricPlatform implements IPlatform {

    @Override
    public ResourceLocation getResourceLocation(Item item) {
        return Registry.ITEM.getKey(item);
    }

    @Override
    public boolean isModLoaded(String name) {
        return FabricLoader.getInstance().isModLoaded(name);
    }

}
