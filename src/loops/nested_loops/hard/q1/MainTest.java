package loops.nested_loops.hard.q1;

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
                new PlaceHolder()
        };
    }

    public void runMain() {
        PrimeTime.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(30, new int[]{3, 5, 7, 11, 13, 17, 19, 23, 29}), Arguments.of(3, new int[]{3}),
                Arguments.of(29, new int[]{3, 5, 7, 11, 13, 17, 19, 23, 29}, Arguments.of(1, new int[]{})),
                Arguments.of(100, new int[]{3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97}));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsPrimeNumbersCorrectly(int n, int[] primes) throws InvalidClauseException {
        int j = 0;
        Clause[][] c = new Clause[1][primes.length * 2];
        for(int i = 0; i < c[0].length; i+=2){
            c[0][i] = new IntegerLiteral(primes[j]);
            c[0][i + 1] = new StringLiteral(" ");
            j++;
        }
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly calculate and print the primes from 3 to n.";
        runWithInput(String.valueOf(n), c);
    }
}
