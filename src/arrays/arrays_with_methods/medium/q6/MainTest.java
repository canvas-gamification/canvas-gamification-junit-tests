package arrays.arrays_with_methods.medium.q6;

import global.tools.CustomAssertions;
import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class MainTest {
    // Parsons with distractors

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 10, 1, 7}, new int[]{10, 1}),
                Arguments.of(new int[]{-3, -14, -8, -23, -28, -1, -4}, new int[]{-1, -28}),
                Arguments.of(new int[]{-9999999, 9999999, 5, 12, 14832, -2384}, new int[]{9999999, -9999999}),
                Arguments.of(new int[]{89, 3892, 183, -32829, 1230, 84392, -38291}, new int[]{84392, -38291})
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctSmallAndLargeMethod(int[] arr, int[] sizes) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(OppositeEnds.class, "smallAndLarge", new Object[]{arr}, int[].class);
        CustomAssertions._assertArrayEquals(sizes, (int[]) output, "Your smallAndLarge method does not return an array of the largest" +
                " and smallest element");
    }
}
