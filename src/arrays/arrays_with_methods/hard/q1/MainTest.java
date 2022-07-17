package arrays.arrays_with_methods.hard.q1;

import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest {
    // Java
    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(new int[]{1, 4, -1, 13, -67, 4, 0}, new int[]{2, 5, 0, 14, -66, 5, 1}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{11, -69, 29758, 0, 0, 1111111, 234, -5682, 0, 1, -1, -3453},
                        new int[]{12, -68, 29759, 1, 1, 1111112, 235, -5681, 1, 2, 0, -3452}));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctUpByOneMethod(int[] input, int[] incremented) throws Throwable{
        int[] output = (int[]) MethodUtil.invokeIfMethodExists(IncrementThis.class, "upByOne", new Object[]{input},
                int[].class);
        assertArrayEquals(incremented, output, "Your method does not correctly increment all the values in an array.");
    }
}
