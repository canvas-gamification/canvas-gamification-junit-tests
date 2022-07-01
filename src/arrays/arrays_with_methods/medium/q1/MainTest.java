package arrays.arrays_with_methods.medium.q1;

import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest {
    // Parsons
    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(new int[]{2, 4, 6, 9, -21, 17}, new int[]{2, 6, -21}),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}),
                Arguments.of(new int[]{23, 57, 1, 57, 8, 4, 8, 1, -2246, 9478, 245, 258, 986, 333392, 48372, 1584},
                        new int[]{23, 1, 8, 8, -2246, 245, 986, 48372}),
                Arguments.of(new int[]{11, 12, -24, 124, -12, 12, 124, 754, -124}, new int[]{11, -24, -12, 124, -124}),
                Arguments.of(new int[]{}, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void createsEvenArrayCorrectly(int[] input, int[] output) throws Throwable{
        int[] result = (int[]) MethodUtil.invokeIfMethodExists(OnlyEven.class, "onlyEven", new Object[]{input}, int[].class);
        assertArrayEquals(output, result, "Your method does not correctly create an array using only the even numbered indices of an input array.");
    }

}
