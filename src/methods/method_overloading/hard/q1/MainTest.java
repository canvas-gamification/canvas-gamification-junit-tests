package methods.method_overloading.hard.q1;

import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest {
    // Java
    static Stream<Arguments> oneStringInputProvider() {
        return Stream.of(
                Arguments.of("Hello, how are you doing", 24),
                Arguments.of("", 0),
                Arguments.of("This is a test string to determine if your method works, or else.", 65)
        );
    }

    static Stream<Arguments> twoStringInputProvider() {
        return Stream.of(
                Arguments.of("Hello, how are you doing?", "I am doing well, thank you.", 52),
                Arguments.of("Did you know that this is a JUnit test?", "", 39),
                Arguments.of("", "This is also a test for an empty string you know?0", 50),
                Arguments.of("", "", 0)
        );
    }

    static Stream<Arguments> threeStringInputProvider() {
        return Stream.of(
                Arguments.of("One string.", "Two string.", "Red string, blue string.", 46),
                Arguments.of("One of the strings will contain nothing.", "", "But which one?", 54),
                Arguments.of("", "", "", 0), Arguments.of("", "This string has something to say.", "", 33)
        );
    }

    @ParameterizedTest
    @MethodSource("oneStringInputProvider")
    void correctStringLengthMethodForOneString(String s, int length) throws Throwable {
        Object[][] arguments = {
                {s, String.class}
        };
        MethodTest m = new MethodTest(OneToThree.class, "stringLength", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(length, output, "Your stringLength method does not correctly calculate the length of a single string.");
    }

    @ParameterizedTest
    @MethodSource("twoStringInputProvider")
    void correctStringLengthMethodForTwoStrings(String s1, String s2, int length) throws Throwable {
        Object[][] arguments = {
                {s1, String.class},
                {s2, String.class}
        };
        MethodTest m = new MethodTest(OneToThree.class, "stringLength", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(length, output, "Your stringLength method does not correctly calculate the length of two strings added together.");
    }

    @ParameterizedTest
    @MethodSource("threeStringInputProvider")
    void correctStringLengthMethodForThreeStrings(String s1, String s2, String s3, int length) throws Throwable {
        Object[][] arguments = {
                {s1, String.class},
                {s2, String.class},
                {s3, String.class}
        };
        MethodTest m = new MethodTest(OneToThree.class, "stringLength", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(length, output, "Your stringLength method does not correctly calculate the length of three strings added together.");
    }
}
