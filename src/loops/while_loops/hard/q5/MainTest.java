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
        TestOption.defaultInput = "10";
        return new Clause[]{
            new StringLiteral("Enter a number: "),
                new NewLine(),
                new StringLiteral("Fibonacci Sequence: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        FiboWhat.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(5, new int[]{0, 1, 1, 2, 3, 5}),
                Arguments.of(15, new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610}),
                Arguments.of(0, new int[]{0}));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void computesFibonacciSequenceCorrectly(int n, int[] fib) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly compute and print out the n terms in the Fibonacci sequence.";
        Clause[][] c = new Clause[1][fib.length * 2];
        int j = 0;
        for (int i = 0; i < c[0].length; i += 2){
            c[0][i] = new IntegerLiteral(fib[j]);
            c[0][i + 1] = new StringLiteral(", ");
            j++;
        }
        runWithInput(String.valueOf(n), c);
    }
}
