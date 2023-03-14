package arrays.arrays_with_methods.hard.q1;

import global.MethodTest;
import global.tools.CustomAssertions;
import global.utils.ArrayUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class MainTest {
    // Java
    private static final int incrementAmount = 1;

    static Stream<int[]> inputProvider() {
        return Stream.of(
                new int[]{},
                new int[]{11, -69, 29758, 0, 0, 1111111, 234, -5682, 0, 1, -1, -3453},
                new int[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                ArrayUtil.generateRandomArray(-152, 589, 50)
        );
    }

    private static int[] increment(int[] arr) {
        return Arrays.stream(arr).map(number -> (number + incrementAmount)).toArray();
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctUpByOneMethod(int[] input) throws Throwable {
        int[] incremented = increment(input);
        Object[][] arguments = {
                {input, int[].class}
        };
        MethodTest m = new MethodTest(IncrementThis.class, "upByOne", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(incremented, output, "Your method does not correctly increment all the values in an array.");
    }
}
