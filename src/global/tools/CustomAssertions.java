package global.tools;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class CustomAssertions {
    // Underscore indicates a custom assertion is being used
    public static void _assertTrue(boolean condition, String userMessage, String devMessage) {
        if (!condition) {
            Logger.logMessage(devMessage);
        }
        assertTrue(condition, userMessage);
    }

    public static void _fail(String userMessage, String devMessage) {
        Logger.logMessage(devMessage);
        fail(userMessage);
    }

    public static void assertWithinRange(double value, double lower, double upper, String message) {
        assertTrue(lower <= value && value < upper, message);
    }

    public static void assertWithinRange(int value, int lower, int upper, String message) {
        assertWithinRange((double) value, lower, upper, message);
    }
}
