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

    static Stream<Arguments> inputProvider() {
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

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsPatternCorrectly(int n, Clause[][] c) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the pattern based on input n.";
        runWithInput(String.valueOf(n), c);
    }

}
