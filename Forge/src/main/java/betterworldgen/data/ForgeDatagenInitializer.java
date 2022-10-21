package betterworldgen.data;

import java.util.Collections;

import net.minecraft.data.DataGenerator;

import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import betterworldgen.BetterWorldgen;

@Mod.EventBusSubscriber(modid = BetterWorldgen.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeDatagenInitializer {

    @SubscribeEvent
    public static void configureForgeDatagen(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper disabledHelper = new ExistingFileHelper(Collections.emptyList(), Collections.emptySet(), false, null, null);
        ForgeBlockTagsProvider blockTagsProvider = new ForgeBlockTagsProvider(gen, disabledHelper);

        gen.addProvider(event.includeServer(), new ForgeItemTagProvider(gen, blockTagsProvider, BetterWorldgen.MODID, disabledHelper));
    }

}
