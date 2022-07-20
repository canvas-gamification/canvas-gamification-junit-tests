package methods.method_overloading.hard.q1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest {
    // Java

    static Stream<Arguments> oneStringInputProvider() {
        return Stream.of(Arguments.of("Hello, how are you doing", 24),
                Arguments.of("", 0), Arguments.of("This is a test string to determine if your method works, or else.", 65));
    }

    static Stream<Arguments> twoStringInputProvider() {
        return Stream.of(Arguments.of("Hello, how are you doing?", "I am doing well, thank you.", 52),
                Arguments.of("Did you know that this is a JUnit test?", "", 39),
                Arguments.of("", "This is also a test for an empty string you know?0", 50),
                Arguments.of("", "", 0));
    }

    static Stream<Arguments> threeStringInputProvider() {
        return Stream.of(Arguments.of("One string.", "Two string.", "Red string, blue string.", 46),
                Arguments.of("One of the strings will contain nothing.", "", "But which one?", 54),
                Arguments.of("", "", "", 0), Arguments.of("", "This string has something to say.", "", 33));
    }

    @ParameterizedTest
    @MethodSource("oneStringInputProvider")
    void correctStringLengthMethodForOneString(String s, int length) {
        String failMessage = "Your program does not have a method which returns the length of a single string.";
        int result = (int) invokeIfMethodExists(OneToThree.class, "stringLength", failMessage,
                new Object[]{s}, String.class);
        assertEquals(result, length, "Your method does not correctly calculate the length of a single string.");
    }

    @ParameterizedTest
    @MethodSource("twoStringInputProvider")
    void correctStringLengthMethodForTwoStrings(String s1, String s2, int length) {
        String failMessage = "Your program does not have a method which returns the length of two strings added together.";
        int result = (int) invokeIfMethodExists(OneToThree.class, "stringLength", failMessage,
                new Object[]{s1, s2}, String.class, String.class);
        assertEquals(result, length, "Your method does not correctly calculate the length of two strings added together.");
    }

    @ParameterizedTest
    @MethodSource("threeStringInputProvider")
    void correctStringLengthMethodForThreeStrings(String s1, String s2, String s3, int length) {
        String failMessage = "Your program does not have a method which returns the length of three strings added together.";
        int result = (int) invokeIfMethodExists(OneToThree.class, "stringLength", failMessage,
                new Object[]{s1, s2, s3}, String.class, String.class, String.class);
        assertEquals(result, length, "Your method does not correctly calculate the length of three strings added together.");
    }

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName, String failMessage, Object[] arguments, Class<?>... methodArgumentTypes) {
        try {
            Method m = methodClass.getMethod(methodName, methodArgumentTypes);
            return m.invoke(null, arguments);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            fail(failMessage);
            return null;
        }
    }
}
