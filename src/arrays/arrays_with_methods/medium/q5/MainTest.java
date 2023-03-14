package arrays.arrays_with_methods.medium.q5;

import global.MethodTest;
import global.tools.CustomAssertions;
import global.utils.ArrayUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest {
    // Parsons with distractors
    private static final int divisor = 4;

    static Stream<int[]> inputProvider() {
        return Stream.of(
                multiply(ArrayUtil.generateRandomArray(-100, 100, 20)),
                ArrayUtil.generateRandomArray(-50, 50, 25),
                ArrayUtil.generateRandomArray(-150, 12385, 25),
                multiply(ArrayUtil.generateRandomArray(-753, 30983, 35)),
                new int[]{0, 0, 0, 0}
        );
    }

    private static int[] multiply(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] *= divisor;
        return arr;
    }

    private static boolean isDivisible(int[] arr) {
        for (int item : arr) {
            if (item % divisor != 0)
                return false;
        }
        return true;
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctIsItDivisibleMethod(int[] input) throws Throwable {
        boolean isDivisible = isDivisible(input);
        Object[][] arguments = {
                {input, int[].class}
        };
        MethodTest m = new MethodTest(DivideThis.class, "isItDivisible", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(isDivisible, output, "Your method does not correctly calculate if all the elements of an array are divisible by the specified value.");
    }
}
