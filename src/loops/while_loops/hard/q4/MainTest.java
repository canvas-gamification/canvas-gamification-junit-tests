package loops.while_loops.hard.q4;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.Logger;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        FactorThis.main(new String[0]);
    }

    static Stream<Arguments> validInputProvider() {
        return Stream.of(Arguments.of(10, new int[]{1, 2, 5, 10}), Arguments.of(0, new int[0]),
                Arguments.of(840, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 14, 15, 20, 21, 24, 28, 30, 35, 40, 42, 56, 60, 70, 84, 105, 120, 140, 168, 210, 280, 420, 840}));
    }

    static Stream<Integer> invalidInputProvider() {
        return Stream.of(-1, -2, -34632);
    }

    @ParameterizedTest
    @MethodSource("validInputProvider")
    void calculatesFactorsCorrectly(int n, int[] list) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly calculate and print the factors of an integer.";
        int j = 0;
        Clause[][] c = new Clause[1][list.length * 2 + 4];
        c[0][0] = new StringLiteral("The factors of ");
        c[0][1] = new IntegerLiteral(n);
        c[0][2] = new StringLiteral(" are: ");
        c[0][3] = new NewLine();
        for (int i = 4; i < c[0].length; i += 2) {
            c[0][i] = new IntegerLiteral(list[j]);
            j++;
            c[0][i + 1] = new StringLiteral(" ");
        }
        runWithInput(String.valueOf(n), c);
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void printsErrorMessageForInvalidInput(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print an error message for invalid inputs.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral("Invalid input!")
        });
    }

}
