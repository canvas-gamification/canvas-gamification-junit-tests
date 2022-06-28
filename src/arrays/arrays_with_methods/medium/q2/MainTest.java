package arrays.arrays_with_methods.medium.q2;

import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest {
    // Parsons
    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(new double[]{2.6, 11.9, 5.3}, new double[]{3.2, 99.9}, new double[]{3.2, 99.9}),
                Arguments.of(new double[]{991.7, 56.4, 98.333333}, new double[]{0.02, 991.8, 34.555, 34.993, 56.78}, new double[]{0.02, 991.8, 34.555, 34.993, 56.78}),
                Arguments.of(new double[]{0, 0, 0, 0, 0, 0}, new double[]{0, 0, 0}, new double[]{0, 0, 0}));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void returnsCorrectArray(double[] input1, double[] input2, double[] higher) {
        double[] output = (double[]) MethodUtil.invokeIfMethodExists(HighestArray.class, "highest", new Object[]{input1, input2},
                double[].class, double[].class);
        assertArrayEquals(higher, output, "Your method does not return the array with the greatest number in it.");
    }
}
