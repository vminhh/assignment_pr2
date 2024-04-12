package a2_2201040110;

/**
 * @overview PCFactory is a singleton class.
 *           It has a factory method for creating PCs
 */
public class PCFactory {
    private static PCFactory factory;

    // private constructor to prevent instantiation
    private PCFactory() {
    }

    /**
     * @return singleton instance
     */
    public static PCFactory getFactory() {
        if (factory == null) {
            factory = new PCFactory();
        }

        return factory;
    }

    /**
     * @effects create PC
     */
    public PC createPC(String model, int year, String manufacturer, Set<String> comps) {
        return new PC(model, year, manufacturer, comps);
    }
}
