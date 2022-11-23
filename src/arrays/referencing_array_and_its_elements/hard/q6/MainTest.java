package arrays.referencing_array_and_its_elements.hard.q6;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static global.utils.ArrayUtil.arrayToInput;
import static global.utils.ArrayUtil.generateRandomArray;
import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public static int n = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "3 4 6 21 48 42 89 2 0 91";
        return new Clause[]{
                new StringLiteral("Enter an array of size " + n + " to split in half:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The first half of the array is:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        RightDownTheMiddle.main(new String[0]);
    }

    public static String split(int[] a) {
        return arrayToInput(Arrays.copyOf(a, a.length / 2));
    }

    static Stream<Arguments> mainInputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(-1000000000, 1000000000, n)),
                Arguments.of(generateRandomArray(-1000000000, 1000000000, n)),
                Arguments.of(generateRandomArray(-1000000000, 1000000000, n))
        );
    }

    @ParameterizedTest
    @MethodSource("mainInputProvider")
    void printsCorrectOutput(int[] input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly split the array in half.";
        runWithInput(
                arrayToInput(input),
                new Clause[]{
                        new StringLiteral(split(input))
                }
        );
    }


    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(-1000000000, 1000000000, n)),
                Arguments.of(new int[]{}),
                Arguments.of(new int[]{1, 2}),
                Arguments.of(generateRandomArray(-1000000000, 1000000000, 100000))
        );
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void correctSplitHalfMethod(int[] input) throws Throwable {
        Object[][] arguments = {
                {input, int[].class},
        };
        MethodTest m = new MethodTest(RightDownTheMiddle.class, "splitHalf", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(split(input), output, "Your splitHalf method does not correctly split the array in half.");
    }


}
