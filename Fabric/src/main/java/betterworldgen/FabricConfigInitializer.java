package betterworldgen;

import com.illusivesoulworks.spectrelib.config.SpectreConfigInitializer;

public class FabricConfigInitializer implements SpectreConfigInitializer {

    @Override
    public void onInitialize() {
        BetterWorldgen.init();
    }

}
