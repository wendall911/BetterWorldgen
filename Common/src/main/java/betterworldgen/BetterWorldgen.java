package betterworldgen;

import com.illusivesoulworks.spectrelib.config.SpectreConfig;
import com.illusivesoulworks.spectrelib.config.SpectreConfigLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import betterworldgen.config.ConfigHandler;
import betterworldgen.platform.Services;

public class BetterWorldgen {

    public static final String MODID = "betterworldgen";
    public static final String MOD_NAME = "Better Worldgen";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        SpectreConfig commonConfig = SpectreConfigLoader.add(SpectreConfig.Type.COMMON, ConfigHandler.COMMON_SPEC, MODID);
        commonConfig.addLoadListener(config -> ConfigHandler.init());
        commonConfig.addReloadListener(config -> ConfigHandler.init());
    }

}
