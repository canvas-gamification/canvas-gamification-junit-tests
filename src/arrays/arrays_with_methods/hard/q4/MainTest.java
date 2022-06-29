package arrays.arrays_with_methods.hard.q4;

import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    // Java
    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(new double[]{1.4, 1.5, 1.5, 1.6, 3.4, 99.5, 99.2}, false),
                Arguments.of(new double[]{-134.56, -134.55, -15.78, -4.556355, 0, 1, 1.45, 3.1415926, 4445.63455}, true),
                Arguments.of(new double[]{}, true),
                Arguments.of(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, true),
                Arguments.of(new double[]{45, 11, 54.75, 232.564, -12442.3456, 123.456}, false),
                Arguments.of(new double[]{1452, -45, 125, 356, 2566, 3497}, false),
                Arguments.of(new double[]{-45, 1157, 2462, 8743, 8743, 8743, 8743, 8744, 478393}, true));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctIsAscendingMethod(double[] input, boolean isAscending) {
        boolean output = (boolean) MethodUtil.invokeIfMethodExists(NumbersAscend.class, "isAscending",
                new Object[]{input}, double[].class);
        assertEquals(isAscending, output,
                "Your method does not return the correct boolean value based on the input array.");
    }
}
