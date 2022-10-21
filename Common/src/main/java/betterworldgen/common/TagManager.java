package betterworldgen.common;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static betterworldgen.util.ResourceLocationHelper.prefix;

public class TagManager {

    public static class Items {

        public static final TagKey<Item> EXAMPLE = itemTag(prefix("example"));

        private static TagKey<Item> itemTag (ResourceLocation loc) {
            return TagKey.create(Registry.ITEM_REGISTRY, loc);
        }
    }

}
