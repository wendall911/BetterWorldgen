package betterworldgen.platform;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import betterworldgen.platform.services.IPlatform;

public class ForgePlatform implements IPlatform {

    @Override
    public ResourceLocation getResourceLocation(Item item) {
        return ForgeRegistries.ITEMS.getKey(item);
    }

    @Override
    public boolean isModLoaded(String name) {
        return ModList.get().isLoaded(name);
    }

}
