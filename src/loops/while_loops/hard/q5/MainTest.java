package loops.while_loops.hard.q5;

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

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        FiboWhat.main(new String[0]);
    }

    static Stream<Arguments> validInputProvider() {
        return Stream.of(Arguments.of(5, new int[]{0, 1, 1, 2, 3, 5}),
                Arguments.of(23, new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657}),
                Arguments.of(0, new int[]{0}));
    }

    static Stream<Integer> invalidInputProvider() {
        return Stream.of(-1, -2, -214413);
    }

    @ParameterizedTest
    @MethodSource("validInputProvider")
    void computesFibonacciSequenceCorrectly(int n, int[] fib) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly compute and print out the Fibonacci sequence up to the nth term.";
        Clause[][] c = new Clause[1][fib.length * 2 + 1];
        c[0][0] = new StringLiteral("Fibonacci Sequence: ");
        int j = 0;
        for (int i = 1; i < c[0].length; i += 2) {
            c[0][i] = new IntegerLiteral(fib[j]);
            c[0][i + 1] = new StringLiteral(", ");
            j++;
        }
        runWithInput(String.valueOf(n), c);
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void printsErrorMessageForInvalidInput(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print an error message for invalid input.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral("Invalid input!")
        });
    }
}
