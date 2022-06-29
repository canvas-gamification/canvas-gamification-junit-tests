package arrays.arrays_with_methods.medium.q4;

import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest {
    // Parsons
    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(new int[]{3, 6, 9}, new int[]{3, 6, 9, 3, 6, 9}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{0, 224532, -11, 39, 44, 2}, new int[]{0, 224532, -11, 39, 44, 2, 0, 224532, -11, 39, 44, 2}),
                Arguments.of(new int[]{11, 454, 12, 45521, -6, 7093, 593, 325, 5947, -2355}, new int[]{11, 454, 12, 45521, -6, 7093, 593, 325, 5947, -2355, 11, 454, 12, 45521, -6, 7093, 593, 325, 5947, -2355}));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctDoubleTroubleMethod(int[] input, int[] result) {
        int[] output = (int[]) MethodUtil.invokeIfMethodExists(DoubleTrouble.class, "doubleTrouble", new Object[]{input},
                int[].class);
        assertArrayEquals(result, output, "Your method does not return an array with the elements copied twice.");
    }
}
