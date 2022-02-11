package global.tools;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomAssertions {
    // Underscore indicates a custom assertion is being used
    public static void _assertTrue(boolean condition, String userMessage, String devMessage) {
        assertTrue(condition, userMessage);
        // Or some way to make the dev see this message without it being returned as an assertion failure message
        System.out.println(devMessage);
    }

    public static void assertWithinRange(double value, double lower, double upper, String message) {
        assertTrue(lower <= value && value < upper, message);
    }

    public static void assertWithinRange(int value, int lower, int upper, String message) {
        assertWithinRange((double) value, lower, upper, message);
    }
}