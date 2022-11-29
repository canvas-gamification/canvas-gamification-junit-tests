package arrays.programs_involving_data_sequences.hard.q6;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;
import static org.junit.Assert.assertArrayEquals;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";
        return new Clause[]{
                new StringLiteral("Enter a positive integer n:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The Fibonacci sequence of "),
                new IntegerLiteral(),
                new StringLiteral(" is:"),
                new NewLine(),
                new PlaceHolder(),
                new Optional(new StringLiteral(" "))
        };
    }

    public void runMain() {
        FibBeat.main(new String[0]);
    }

    public static int[] fib(int n) {
        int[] out = new int[n + 1];
        out[0] = 0;
        if (n >= 1)
            out[1] = 1;
        if (n >= 2)
            for (int i = 2; i <= n; i++)
                out[i] = out[i - 1] + out[i - 2];
        return out;
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(10),
                Arguments.of(100),
                Arguments.of(10000)


        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printCorrectOutput(int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct fibonacci sequence.";
        runWithInput(Integer.toString(n), new Clause[]{
                new StringLiteral(arrayToInput(fib(n)))
        });
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void correctFibonacciMaker(int n) throws Throwable {
        Object[][] arguments = {
                {n, int.class},
        };
        MethodTest m = new MethodTest(FibBeat.class, "fibonacciMaker", arguments);
        m.setIncorrectMethodStructureErrorMessage("Your fibonacciMaker method does not calculate the correct fibonacci sequence up to nth element.");
        Object output = m.callMethod();
        assertArrayEquals((int[]) output, fib(n));
    }

}
