package betterworldgen.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import net.minecraft.data.tags.BlockTagsProvider;

public class FabricDatagenInitializer implements DataGeneratorEntrypoint {

    private static BlockTagsProvider blockTagsProvider;

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        blockTagsProvider = new BlockTagsProvider(gen);

        if (System.getProperty("betterworldgen.common_datagen") != null) {
            configureCommonDatagen(gen);
        }
        else {
            configureFabricDatagen(gen);
        }
    }

    public static void configureCommonDatagen(FabricDataGenerator gen) {
    }

    public static void configureFabricDatagen(FabricDataGenerator gen) {
    }

}
