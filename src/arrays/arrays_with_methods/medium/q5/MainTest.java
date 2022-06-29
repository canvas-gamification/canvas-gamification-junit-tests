package arrays.arrays_with_methods.medium.q5;

import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    // Parsons with distractors
    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(new int[]{4, 16, 8, 224, 64, 0}, true),
                Arguments.of(new int[]{4, 16, 424, 1000, 9, 8, 2956}, false),
                Arguments.of(new int[]{}, true),
                Arguments.of(new int[]{5, 4, 16, 24, 44, 120}, false),
                Arguments.of(new int[]{4, 16, 424, 1000, 99}, false),
                Arguments.of(new int[]{560, 48, 5960, 992, -4, -452, 1028, 55988}, true));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctIsItDivisibleMethod(int[] input, boolean isDivisible) {
        boolean output = (boolean) MethodUtil.invokeIfMethodExists(DivideThis.class, "isItDivisible", new Object[]{input},
                int[].class);
        assertEquals(isDivisible, output, "Your method does not correctly calculate if all the elements of an array are divisible by 4.");
    }
}
