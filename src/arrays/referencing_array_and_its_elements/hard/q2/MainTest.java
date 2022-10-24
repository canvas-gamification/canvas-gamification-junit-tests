package arrays.referencing_array_and_its_elements.hard.q2;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest extends BaseTest {
    // Java

    int[] arr = {3, 4, 6, 21, 48, 42, 89, 2, 0};
    static int subsection = 1; // 0 for the first subarray, 1 for the second and 2 for the third

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * arr.length / 3];
        for (int i = 0; i < 2 * arr.length / 3; i += 2) {
            c[i] = new IntegerLiteral((i / 2) + "");
            c[i + 1] = new StringLiteral(" ");
        }
        return c;
    }

    public void runMain() {
        InThirds.main(new String[0]);
    }

    public static int[] answerFor(int[] array) {
        int size = array.length;
        int[] first = new int[size / 3];
        int[] second = new int[size / 3];
        int[] third = new int[size / 3];
        for (int i = 0; i < size; i++) {
            if (i < (size / 3))
                first[i] = array[i];
            else if (size / 3 <= i && i < (2 * size / 3))
                second[i - (size / 3)] = array[i];
            else
                third[i - (2 * size / 3)] = array[i];
        }
        if (subsection == 0)
            return first;
        if (subsection == 1)
            return second;
        if (subsection == 2)
            return third;
        return null;

    }

    @Test
    public void mainMethodTest() {
        int[] ex = answerFor(arr);
        int[] ans = new int[arr.length / 3];
        for (int i = 0; i < arr.length / 3; i++) {
            ans[i] = Integer.parseInt(getItemByName(i + ""));
        }
        assertArrayEquals(ex, ans, "Your program doest not display the correct output");
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 6, 21, 48, 42, 89, 2, 0}, answerFor(new int[]{3, 4, 6, 21, 48, 42, 89, 2, 0})),
                Arguments.of(new int[]{1, 2, 3}, answerFor(new int[]{1, 2, 3})),
                Arguments.of(new int[]{}, answerFor(new int[]{})),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, answerFor(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}))


        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void splitterMethodTest(int[] input, int[] ans) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(InThirds.class, "splitter", new Object[]{input}, int[].class);
        CustomAssertions._assertArrayEquals(ans, output, "Your splitter method does not divide the array correctly");
    }
}
