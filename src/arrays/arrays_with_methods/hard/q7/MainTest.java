package arrays.arrays_with_methods.hard.q7;

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
                Arguments.of(new int[]{}, new int[]{}, true),
                Arguments.of(new int[]{1, 2, 3, 5, 4}, new int[]{1, 2, 3, 4, 5}, false),
                Arguments.of(new int[]{2, 2, 2, 2, 2, 2}, new int[]{2, 2, 2, 2, 2, 2}, true),
                Arguments.of(new int[]{4, 4, 4}, new int[]{4}, false),
                Arguments.of(new int[]{6, 7}, new int[]{6, 7, 8}, false),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2}, false),
                Arguments.of(new int[]{352, 85326, 5372, 5893, 475642}, new int[]{352, 85326, 5372, 5893, 475642}, true),
                Arguments.of(ArrayUtil.generateRandomArray(0, 100, 300), ArrayUtil.generateRandomArray(10, 100, 300), false),
                Arguments.of(ArrayUtil.generateAscendingArray(5, 490), ArrayUtil.generateAscendingArray(5, 490), true),
                Arguments.of(reverse(ArrayUtil.generateAscendingArray(1, 400)), ArrayUtil.generateAscendingArray(1, 400), false)
        );
    }

    static int[] reverse(int[] in) {
        int n = in.length;
        for (int x = 0; x < n / 2; x++) {
            int hold = in[x];
            in[x] = in[n - x - 1];
            in[n - x - 1] = hold;
        }
        return in;
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctIsEqualMethod(int[] one, int[] two, boolean equal) throws Throwable {
        Object[][] arguments = {
                {one, int[].class},
                {two, int[].class}
        };
        MethodTest m = new MethodTest(ArraySimilarity.class, "isEqual", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(equal, output, "Your isEqual method does not return the correct boolean when evaluating if the arrays are the same.");
    }
}
