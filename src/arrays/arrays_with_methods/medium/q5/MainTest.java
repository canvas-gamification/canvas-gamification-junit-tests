package arrays.arrays_with_methods.medium.q5;

import global.tools.CustomAssertions;
import global.utils.ArrayUtil;
import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest {
    // Parsons with distractors
    private static final int divisor = 4;

    static Stream<int[]> inputProvider() {
        return Stream.of(
                multiply(ArrayUtil.generateRandomIntArray(-100, 100, 20)),
                ArrayUtil.generateRandomIntArray(-50, 50, 25),
                ArrayUtil.generateRandomIntArray(-150, 12385, 25),
                multiply(ArrayUtil.generateRandomIntArray(-753, 30983, 35)),
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
        Object output = MethodUtil.invokeIfMethodExists(DivideThis.class, "isItDivisible", new Object[]{input},
                int[].class);
        CustomAssertions._assertEquals(isDivisible, output, "Your method does not correctly calculate if all the elements of an array are divisible by the specified value.");
    }
}
