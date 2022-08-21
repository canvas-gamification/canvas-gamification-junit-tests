package global.tools;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

public class CustomAssertions {
    // Underscore indicates a custom assertion is being used
    public static void _assertTrue(boolean condition, String userMessage, String devMessage) {
        if (!condition) {
            Logger.logMessage(devMessage);
        }
        assertTrue(condition, userMessage);
    }

    public static void _assertEquals(Object expected, Object actual, String userMessage) {
        _assertSameTypes(expected, actual);
        assertEquals(expected, actual, userMessage);
    }

    public static void _assertEquals(Object expected, Object actual, double delta, String userMessage) {
        _assertSameTypes(expected, actual);
        if (expected instanceof Double)
            assertEquals((double) expected, (double) actual, delta, userMessage);
        else
            fail("Error with test definition: a custom assert was used with the wrong type.");
    }

    public static void _assertArrayEquals(Object expected, Object actual, String userMessage) {
        _assertSameTypes(expected, actual);
        if (expected.getClass().isArray()) {
            int expectedLength = Array.getLength(expected);
            int actualLength = Array.getLength(actual);
            Object[] expectedArray = new Object[expectedLength];
            Object[] actualArray = new Object[actualLength];
            for (int i = 0; i < expectedLength; i++)
                expectedArray[i] = Array.get(expected, i);
            for (int i = 0; i < actualLength; i++)
                actualArray[i] = Array.get(actual, i);
            assertArrayEquals(expectedArray, actualArray, userMessage);
        } else
            fail("Error with test definition: a custom assert was used with the wrong type.");
    }

    public static void _assertSameTypes(Object expected, Object actual) {
        String message = String.join(" ",
                "Received",
                TypeMatcher.simplifyPrimitiveTypeName(actual.getClass().getCanonicalName()),
                "type, but expected",
                TypeMatcher.simplifyPrimitiveTypeName(expected.getClass().getCanonicalName()),
                "type."
        );
        assertSame(expected.getClass().getCanonicalName(), actual.getClass().getCanonicalName(), message);
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
