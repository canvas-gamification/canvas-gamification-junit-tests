package arrays.arrays_with_methods.hard.q7;

import global.tools.CustomAssertions;
import global.utils.MethodUtil;
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
                Arguments.of(new int[]{352, 85326, 5372, 5893, 475642}, new int[]{352, 85326, 5372, 5893, 475642}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctIsEqualMethod(int[] one, int[] two, boolean equal) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(ArraySimilarity.class, "isEqual", new Object[]{one, two}, int[].class, int[].class);
        CustomAssertions._assertEquals(equal, output, "Your isEqual method does not return the correct boolean.");
    }
}
