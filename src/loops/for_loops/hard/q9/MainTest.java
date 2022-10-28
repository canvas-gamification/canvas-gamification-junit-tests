package loops.for_loops.hard.q9;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
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
        TestOption.defaultInput = "67 9";
        return new Clause[]{
                new StringLiteral("Enter two integers: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        CommonDivisors.main(new String[0]);
    }

    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of(10, 4, "true"),
                Arguments.of(6, 3, "true"),
                Arguments.of(150, 75, "true"),
                Arguments.of(99999, 9, "true"),
                Arguments.of(10, 3, "false"),
                Arguments.of(131, 15, "false"),
                Arguments.of(21, 2, "false"),
                Arguments.of(2, 1, "false"),
                Arguments.of(99999, 7, "false"));
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void testingTheOutput(int s1, int s2, String ans) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not correctly identify if the two input integers have a common divisor greater than one.";
        runWithInput(s1 + " " + s2, new Clause[]{
                new StringLiteral(ans)});
    }

}
