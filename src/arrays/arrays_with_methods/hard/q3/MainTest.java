package arrays.arrays_with_methods.hard.q3;

import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    // Java
    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(new int[]{2, 4, -6, -50, -8, 10, 12}, -49, 14),
                Arguments.of(new int[]{}, 11, 0),
                Arguments.of(new int[]{387, 956, 23, 57, 28, -111, 48576}, 28, 50004),
                Arguments.of(new int[]{-11, -57, -124, -125, 85, -37, 0, 1, -11}, -124, -154),
                Arguments.of(new int[]{1, 4, 2, -11, 4, 1, 55, -45, 12, 395}, 396, 0),
                Arguments.of(new int[]{-11, -1, -1, -457, -56, -3442, 0, 0, 0, 1}, 0, 1));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctSelectiveSumMethod(int[] input, int n, int sum) throws Throwable{
        int output = (int) MethodUtil.invokeIfMethodExists(SumTimes.class, "selectiveSum", new Object[]{input, n},
                int[].class, int.class);
        assertEquals(sum, output, "Your method does not correctly calculate the sum of the values in an array greater than or equal to a given number.");
    }
}
