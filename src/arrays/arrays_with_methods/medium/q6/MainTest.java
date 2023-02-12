package arrays.arrays_with_methods.medium.q6;

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
                Arguments.of(new int[]{5, 4, 10, 1, 7}, new int[]{10, 1}),
                Arguments.of(new int[]{3, 14, 8, 23, 28, 1, 4}, new int[]{28, 1}),
                Arguments.of(new int[]{0, 100, 5, 12, 48, 83}, new int[]{100, 0}),
                Arguments.of(new int[]{89, 92, 13, 29, 30, 43, 38}, new int[]{92, 13})
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctSmallAndLargeMethod(int[] arr, int[] sizes) throws Throwable {
        Object[][] arguments = {
                {arr, int[].class}
        };
        MethodTest m = new MethodTest(OppositeEnds.class, "smallAndLarge", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(sizes, output, "Your smallAndLarge method does not return an array of the largest" +
                " and smallest elements");
    }
}
