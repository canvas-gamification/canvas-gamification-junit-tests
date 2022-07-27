package loops.programs_with_repetition.medium.q5;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";
        return new Clause[]{
                new StringLiteral("How wide is your arrow\\?"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        ThatWay.main(new String[0]);
    }

    static Stream<Arguments> inputProviderValid() {
        return Stream.of(
                Arguments.of(90, arrowPatternClause(90)),
                Arguments.of(60, arrowPatternClause(60)),
                Arguments.of(10, arrowPatternClause(10)),
                Arguments.of(5, arrowPatternClause(5)),
                Arguments.of(1, new Clause[][]{{new StringLiteral("\\* "), new NewLine()}}));
    }

    static Stream<Integer> inputProviderInvalid() {
        return Stream.of(0, -1, -5, -10);
    }

    @ParameterizedTest
    @MethodSource("inputProviderValid")
    public void printsArrowPatternCorrectly(int width, Clause[][] arrow) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the arrow pattern correctly.";
        runWithInput(width + "", arrow);
    }

    @ParameterizedTest
    @MethodSource("inputProviderInvalid")
    public void printsErrorMessageForInvalidInput(int width) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print an error message for invalid inputs.";
        runWithInput(width + "", new Clause[]{new StringLiteral("Invalid Input!")});
    }

    static Clause[][] arrowPatternClause(int n) {
        Clause[][] c = new Clause[1][n * 4 - 2];
        int index = 0;
        for (int i = 1; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            sb.append("\\* ".repeat(i));
            c[0][index++] = new StringLiteral(sb.toString());
            c[0][index++] = new NewLine();
        }
        for (int i = n - 1; i >= 1; --i) {
            StringBuilder sb = new StringBuilder();
            sb.append("\\* ".repeat(i));
            c[0][index++] = new StringLiteral(sb.toString());
            c[0][index++] = new NewLine();
        }

        return c;
    }
}
