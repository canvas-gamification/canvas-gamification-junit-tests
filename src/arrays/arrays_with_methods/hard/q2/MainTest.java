package arrays.arrays_with_methods.hard.q2;

import global.MethodTest;
import global.tools.CustomAssertions;
import global.utils.ArrayUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest {
    // Java
    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new int[]{0, -11, 4561254, 2}, new int[]{4, -12241, 1, 5, 1241, 0, 0, 0, 124}),
                Arguments.of(new int[]{2, 5, 1, 7, -8, 2}, new int[]{2, 3, 4, 6, 9}),
                Arguments.of(new int[]{5, 8, -1}, new int[]{9, 1, 1}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{5, 213, 12, -21, 254}, new int[]{34525, 12, 52}),
                Arguments.of(ArrayUtil.generateRandomArray(0, 10000, 30), ArrayUtil.generateRandomArray(0, 4, 31))
        );
    }

    private static int[] longer(int[] arr1, int[] arr2) {
        return arr1.length < arr2.length ? arr2 : arr1;
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctWhoIsLongerMethod(int[] a, int[] b) throws Throwable {
        int[] longer = longer(a, b);
        Object[][] arguments = {
                {a, int[].class},
                {b, int[].class}
        };
        MethodTest m = new MethodTest(Longer.class, "whoIsLonger", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(longer, output, "Your method does not return the longer array.");
    }
}
