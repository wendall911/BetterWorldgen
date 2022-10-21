package betterworldgen.util;

import net.minecraft.resources.ResourceLocation;

import betterworldgen.BetterWorldgen;

public class ResourceLocationHelper {

    public static ResourceLocation prefix(String path) {
        return new ResourceLocation(BetterWorldgen.MODID, path);
    }

}
