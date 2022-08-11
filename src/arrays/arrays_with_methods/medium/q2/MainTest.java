package arrays.arrays_with_methods.medium.q2;

import global.tools.CustomAssertions;
import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest {
    // Parsons
    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(new double[]{2.6, 11.9, 5.3}, new double[]{3.2, 99.9}, new double[]{3.2, 99.9}),
                Arguments.of(new double[]{0.02, 991.8, 34.555, 34.993, 56.78}, new double[]{991.7, 56.4, 98.333333}, new double[]{0.02, 991.8, 34.555, 34.993, 56.78}),
                Arguments.of(new double[]{0, 0, 0, 0, 0, 0}, new double[]{0, 0, 0}, new double[]{0, 0, 0}),
                Arguments.of(new double[]{125.234, 11.2452, 10675.3421}, new double[]{1, 56, 4356.43536, 12, 2344.52, 124.335213521}, new double[]{125.234, 11.2452, 10675.3421}));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctHighestMethod(double[] input1, double[] input2, double[] higher) throws Throwable{
        Object output = MethodUtil.invokeIfMethodExists(HighestArray.class, "highest", new Object[]{input1, input2},
                double[].class, double[].class);
        CustomAssertions._assertArrayEquals(higher, output, "Your method does not return the array with the greatest number in it.");
    }
}
