package betterworldgen.platform;

import java.util.ServiceLoader;

import betterworldgen.BetterWorldgen;
import betterworldgen.platform.services.IPlatform;

public class Services {

    public static final IPlatform PLATFORM = load(IPlatform.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
            .findFirst()
            .orElseThrow(
                () -> new NullPointerException("Failed to load service for " + clazz.getName()));
        BetterWorldgen.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);

        return loadedService;
    }

}
