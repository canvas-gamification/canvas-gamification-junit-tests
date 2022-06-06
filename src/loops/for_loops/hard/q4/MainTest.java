package loops.for_loops.hard.q4;

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

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new StringLiteral("Factors of "),
                new IntegerLiteral(),
                new StringLiteral(" are: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        FactorThis.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(10, "1 2 5 10 "), Arguments.of(67, "1 67 "), Arguments.of(32, "1 2 4 8 16 32 "),
                Arguments.of(1375, "1 5 11 25 55 125 275 1375 "), Arguments.of(0, ""));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsFactorsOfInputNumber(int input, String s) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not calculate and print the factors of a number correctly.";
        runWithInput(input + " ", new Clause[]{
                new StringLiteral(s)
        });
    }
}
