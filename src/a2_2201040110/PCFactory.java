package a2_2201040110;

/**
 * @overview PCFactory is a program creating PC.
 *           This class must also be a singleton.
 */
public class PCFactory {
    private static PCFactory factory = new PCFactory();

    private PCFactory() {
        // private constructor to prevent instantiation
    }

    public static PCFactory getFactory() {
        return factory;
    }

    // create new PC
    public PC createPC(String model, int year, String manufacturer, Set<String> comps) {
        return new PC(model, year, manufacturer, comps);
    }
}
