package betterworldgen.config;

import java.util.HashMap;
import java.util.Map;

import com.illusivesoulworks.spectrelib.config.SpectreConfigSpec;

import org.apache.commons.lang3.tuple.Pair;

public class ConfigHandler {

    public static final SpectreConfigSpec COMMON_SPEC;
    public static final Map<String, Boolean> conditionsMap = new HashMap<>();

    private static final Common COMMON;

    static {
        final Pair<Common, SpectreConfigSpec> specPairCommon = new SpectreConfigSpec.Builder().configure(Common::new);

        COMMON_SPEC = specPairCommon.getRight();
        COMMON = specPairCommon.getLeft();

    }

    public static void init() {
        conditionsMap.clear();
        conditionsMap.put("disableExampleFeature", Common.disableExampleFeature());
    }

    public static class Common {

        private final SpectreConfigSpec.BooleanValue disableExampleFeature;

        public Common(SpectreConfigSpec.Builder builder) {
            builder.push("tweaks");

            disableExampleFeature = builder.comment("Disable Example Feature")
                    .define("disableExampleFeature", false);

            builder.pop();
        }

        public static boolean disableExampleFeature() {
            return COMMON.disableExampleFeature.get();
        }

    }

}