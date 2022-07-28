package loops.programs_with_repetition.hard.q5;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "36";
        return new Clause[]{
                new StringLiteral("Enter a number:"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        PrimeFactor.main(new String[0]);
    }

    static Stream<Arguments> validInputProvider() {
        return Stream.of(
                Arguments.of(36, new int[]{2, 3}),
                Arguments.of(0, new int[]{}),
                Arguments.of(1, new int[]{}),
                Arguments.of(2, new int[]{2}),
                Arguments.of(1486823910, new int[]{2, 3, 5, 11, 13, 17, 19, 29, 37}),
                Arguments.of(108, new int[]{2, 3})
        );
    }

    static Stream<Integer> invalidInputProvider() {
        return Stream.of(-1, -2, -10, -1256);
    }

    @ParameterizedTest
    @MethodSource("validInputProvider")
    void identifiesPrimeFactorsCorrectly(int number, int[] list) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify and print the prime factors of a number.";
        runWithInput(String.valueOf(number), clauseBuilder(number, list));
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void printsErrorMessageForInvalidInput(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print an error message for invalid input.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral("Invalid input!")
        });
    }

    private static Clause[][] clauseBuilder(int number, int[] list) {
        Clause[][] c = new Clause[1][list.length * 2 + 3];
        c[0][0] = new StringLiteral("Factors of ");
        c[0][1] = new IntegerLiteral(number);
        c[0][2] = new StringLiteral(" that are prime numbers are: ");
        int index = 3;
        for (int item : list) {
            c[0][index++] = new IntegerLiteral(item);
            c[0][index++] = new StringLiteral(" ");
        }
        return c;
    }
}
