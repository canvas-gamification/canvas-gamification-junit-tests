package loops.nested_loops.hard.q4;

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
        TestOption.defaultInput = "1";
        return new Clause[]{
                new StringLiteral("Enter the number of lines: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        TryAngleButTheOtherWay.main(new String[0]);
    }

    static Stream<Arguments> validInputProvider() {
        return Stream.of(
                Arguments.of(4, new Clause[][]{{
                        new StringLiteral("   1"),
                        new NewLine(),
                        new StringLiteral("  21"),
                        new NewLine(),
                        new StringLiteral(" 321"),
                        new NewLine(),
                        new StringLiteral("4321")
                }}),
                Arguments.of(9, new Clause[][]{{
                        new StringLiteral("        1"),
                        new NewLine(),
                        new StringLiteral("       21"),
                        new NewLine(),
                        new StringLiteral("      321"),
                        new NewLine(),
                        new StringLiteral("     4321"),
                        new NewLine(),
                        new StringLiteral("    54321"),
                        new NewLine(),
                        new StringLiteral("   654321"),
                        new NewLine(),
                        new StringLiteral("  7654321"),
                        new NewLine(),
                        new StringLiteral(" 87654321"),
                        new NewLine(),
                        new StringLiteral("987654321")
                }}), Arguments.of(0, new Clause[][]{{new StringLiteral("")}}),
                Arguments.of(1, new Clause[][]{{new StringLiteral("1")}}));
    }

    static Stream<Integer> invalidInputProvider(){
        return Stream.of(-1, -2, -344, 10, 11, 4532);
    }

    @ParameterizedTest
    @MethodSource("validInputProvider")
    void printsPatternCorrectly(int n, Clause[][] c) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the pattern based on the input n.";
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
