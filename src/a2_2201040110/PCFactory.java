package a2_2201040110;

/**
 * Singleton
 */
public class PCFactory {
    private static PCFactory factory;

    private PCFactory() {
    }

    public static PCFactory getFactory() {
        if (factory == null) {
            factory = new PCFactory();
        }

        return factory;
    }

    public PC createPC(String model, int year, String manufacturer, Set<String> comps) {
        if (model == null || manufacturer == null)
            throw new IllegalArgumentException("Model and manufacturer must not be null!");

        return new PC(model, year, manufacturer, comps);
    }
}
