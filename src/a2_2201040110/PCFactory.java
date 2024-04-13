package a2_2201040110;

/**
 * @overview PCFactory is a singleton class.
 *           It has a factory method for creating PCs
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

    /**
     * @effects create a new PC
     */
    public PC createPC(String model, int year, String manufacturer, Set<String> comps) {
        if (model == null || manufacturer == null || comps == null)
            throw new IllegalArgumentException("Model, manufacturer, and components must not be null!");

        return new PC(model, year, manufacturer, comps);
    }
}
