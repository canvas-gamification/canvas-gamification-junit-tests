package arrays.arrays_with_methods.medium.q7;

import global.MethodTest;
import global.tools.CustomAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest {
    // Parsons with distractors

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new char[]{'s', 'h', 'c', 'l', 'o', 'p'}, "ujenqr"),
                Arguments.of(new char[]{'f', 'c', 'j', 'n'}, "help"),
                Arguments.of(new char[]{'#', '^', '@', '!', '~', '*'}, "%`B#\u0080,"),
                Arguments.of(new char[]{'4', '2', 'm', '3', '@', 'n', '$'}, "64o5Bp&")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctEncryptItLikeIts1950Method(char[] arr, String result) throws Throwable {
        Object[][] arguments = {
                {arr, char[].class}
        };
        MethodTest m = new MethodTest(SlideToTheRight.class, "encryptItLikeIts1950", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(result, output, "Your encryptItLikeIts1950 method does not correctly connect the altered characters.");
    }
}
