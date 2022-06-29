package arrays.arrays_with_methods.hard.q5;

import global.utils.MethodUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    // Java
    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(new int[]{112, 113, 7, 2, 4, 9, 1}, 1),
                Arguments.of(new int[]{1, 76, 2, -457, 34, 4543, -235, -345, -329}, 16),
                Arguments.of(new int[]{0, 0, 0, 0, 0}, 0),
                Arguments.of(new int[]{-334, 241, -89, -3352, -24341, -12, 245, 511, 155, -7, 349, 12, -21412, 0, 1245}, 162),
                Arguments.of(new int[]{-9, 34, 764, 87, 42, -11, -75, 0}, 43));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctSmallestDiffMethod(int [] input, int difference){
        int output = (int) MethodUtil.invokeIfMethodExists(SmallestDifference.class, "smallestDiff", new Object[]{input},
                int[].class);
        assertEquals(difference, output, "Your method does not correctly calculate the smallest difference between items in an array.");
    }
}
