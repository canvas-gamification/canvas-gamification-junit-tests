package arrays.programs_involving_data_sequences.medium.q4;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons with distractors
    private static final int[] outputArray = new int[]{98, 3, 5, 7, 9};

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The array is now: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        Replacements.main(new String[0]);
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(Arguments.of(new int[]{4, 11, 112, 452, 2, 245}, 39, new int[]{4, 11, 112, 452, 39, 245}),
                Arguments.of(new int[]{}, 11, new int[]{}),
                Arguments.of(new int[]{9563}, -39, new int[]{-39}),
                Arguments.of(new int[]{11, -34, 5, 0, -123, 245, 8876, 2, 1, 5, 4, -457, 10}, -11,
                        new int[]{11, -34, 5, 0, -11, 245, 8876, 2, 1, 5, 4, -457, 10}));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctAddThisOneMethod(int[] array, int number, int[] replaced) throws Throwable {
        Object[][] arguments = {
                {array, int[].class},
                {number, int.class}
        };
        MethodTest m = new MethodTest(Replacements.class, "addThisOne", arguments);
        Object result = m.callMethod();
        CustomAssertions._assertArrayEquals(replaced, result, "Your addThisOne method does not insert the number at the correct index.");
    }

    @Test
    void printsCorrectOutput() throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the array with the replaced element.";
        runWithInput("", new Clause[]{
                new StringLiteral(ArrayUtil.arrayToInput(outputArray))
        });
    }
}
