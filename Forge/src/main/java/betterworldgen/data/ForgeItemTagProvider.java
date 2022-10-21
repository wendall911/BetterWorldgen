package betterworldgen.data;

import java.util.Collections;
import java.util.Objects;

import javax.annotation.Nullable;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import betterworldgen.BetterWorldgen;

public class ForgeItemTagProvider extends ItemTagsProvider {

    public ForgeItemTagProvider(DataGenerator gen, BlockTagsProvider blockTags, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, blockTags, modId, existingFileHelper);
    }

    @Override
    public String getName() {
        return BetterWorldgen.MOD_NAME + " - Item Tags";
    }

    @Override
    protected void addTags() {
    }

    private static ResourceLocation loc(String namespace, String path) {
        return new ResourceLocation(namespace, path);
    }

    private static TagKey<Item> getTagKey(ResourceLocation loc) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).createOptionalTagKey(loc, Collections.emptySet());
    }

}
