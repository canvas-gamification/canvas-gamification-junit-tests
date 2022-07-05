package arrays.programs_involving_data_sequences.medium.q5;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "6 1 3 5 7 9 7 7";
        return new Clause[]{
                new StringLiteral("Enter the desired array length: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        DoTheDeletion.main(new String[0]);
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(Arguments.of(new int[]{3, 4, 5, 0, -11, 3, 3, 1, 5, 3}, 3, 9),
                Arguments.of(new int[]{}, 0, -1),
                Arguments.of(new int[]{1, 5, -11, -11, 2, 3, -11, 5, 4, -100}, 5, 7),
                Arguments.of(new int[]{311, 12, 4, -45, 1, 2, -311}, 311, 0),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5}, 6, -1));
    }

    static Stream<Arguments> mainMethodValidInputProvider() {
        return Stream.of(Arguments.of(10, "3 4 5 0 -11 3 3 1 5 3", 3, new int[]{0, 4, 5, 0, -11, 0, 0, 1, 5, 0}),
                Arguments.of(6, "0 1 2 3 4 5", 6, new int[]{0, 1, 2, 3, 4, 5}),
                Arguments.of(10, "1 5 -11 -11 2 3 -11 5 4 -111", 5, new int[]{1, 0, -11, -11, 2, 3, -11, 0, 4, -111}),
                Arguments.of(7, "311 12 4 -45 1 2 -311", 311, new int[]{0, 12, 4, -45, 1, 2, -311}));
    }

    static Stream<Integer> mainMethodInvalidInputProvider() {
        return Stream.of(0, -1, -2, -4000);
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctDeleteThisMethod(int[] input, int replace, int index) throws Throwable {
        int output = (int) MethodUtil.invokeIfMethodExists(DoTheDeletion.class, "deleteThis",
                new Object[]{input, replace}, int[].class, int.class);
        assertEquals(index, output, "Your program does not return the correct index the item in the array was replaced at.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodValidInputProvider")
    void printsCorrectOutput(int length, String arrayInput, int replace, int[] output) throws InvalidClauseException {
        runWithInput(String.join(" ", String.valueOf(length), arrayInput, String.valueOf(replace)), clauseBuilder(output));
    }

    @ParameterizedTest
    @MethodSource("mainMethodInvalidInputProvider")
    void printsErrorMessageForInvalidInput(int length) throws InvalidClauseException {
        runWithInput(String.valueOf(length), new Clause[]{
                new StringLiteral("Invalid array length!")
        });
    }

    private static Clause[][] clauseBuilder(int[] array) {
        Clause[][] c = new Clause[1][array.length * 2 + 4];
        int j = 0;
        c[0][j++] = new StringLiteral("Enter the numbers for the array: ");
        c[0][j++] = new NewLine();
        c[0][j++] = new StringLiteral("Enter the number to be replaced: ");
        c[0][j++] = new NewLine();
        for (int i = 0; i < array.length; i++) {
            c[0][j] = new IntegerLiteral(array[i]);
            c[0][j + 1] = new StringLiteral(" ");
            j += 2;
        }
        return c;
    }

}
