package arrays.arrays_with_methods.hard.q2;

import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest {
    // Java
    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(new int[]{2, 5, 1, 7, -8, 2}, new int[]{2, 3, 4, 6, 9}, new int[]{2, 5, 1, 7, -8, 2}),
                Arguments.of(new int[]{5, 8, 1}, new int[]{9, 1, 1}, new int[]{5, 8, 1}),
                Arguments.of(new int[]{}, new int[]{}, new int[]{}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 41112, 5}, new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6},
                        new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6}));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctWhoIsLongerMethod(int [] a, int [] b, int [] longer){
        int [] output = (int[]) MethodUtil.invokeIfMethodExists(Longer.class, "whoIsLonger",
                new Object[]{a, b}, int[].class, int[].class);
        assertArrayEquals(longer, output);
    }
}
