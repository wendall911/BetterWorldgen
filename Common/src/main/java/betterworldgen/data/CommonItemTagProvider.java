package betterworldgen.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagBuilder;
import net.minecraft.world.item.Items;

import betterworldgen.common.TagManager;

public class CommonItemTagProvider extends ItemTagsProvider {

    public CommonItemTagProvider(DataGenerator gen, BlockTagsProvider blockTagsProvider) {
        super(gen, blockTagsProvider);
    }

    @Override
    protected void addTags() {
    }

}
