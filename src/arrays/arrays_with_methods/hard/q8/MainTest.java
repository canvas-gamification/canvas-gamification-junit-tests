package arrays.arrays_with_methods.hard.q8;

import global.MethodTest;
import global.tools.CustomAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest {
    // Java

    static Stream<int[]> inputProvider() {
        return Stream.of(
                result(2),
                result(3),
                result(4),
                result(10),
                result(37),
                result(100),
                result(1000)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctFibbingArrayMethod(int[] in) throws Throwable {
        Object[][] arguments = {
                {in.length, int.class}
        };
        MethodTest m = new MethodTest(MakeFibonacci.class, "fibbingArray", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(in, output, "Your fibbingArray method does not return the correct array of Fibonacci numbers.");
    }

    private static int[] result(int size) {
        int[] result = new int[size];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i < result.length; i++)
            result[i] = result[i - 1] + result[i - 2];
        return result;
    }
}
