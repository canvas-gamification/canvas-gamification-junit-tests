package loops.programs_with_repetition.medium.q3;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";
        return new Clause[]{
                new StringLiteral("Enter an integer:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        ThisPatternLooksLikePants.main(new String[0]);
    }

    static Stream<Integer> validInput() {
        return Stream.of(1, 5, 9, 10, 39, 0);
    }

    static Stream<Integer> invalidInput() {
        return Stream.of(-1, -2, -59);
    }

    @ParameterizedTest
    @MethodSource("validInput")
    void printsPantsPatternCorrectly(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print out the pants pattern based on the input integer.";
        runWithInput(String.valueOf(input), clauseBuilder(input));
    }

    @ParameterizedTest
    @MethodSource("invalidInput")
    void printsErrorMessageForInvalidInput(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print an error message for invalid input.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral("Invalid input!")
        });
    }

    private Clause[][] clauseBuilder(int n) {
        Clause[][] c = new Clause[1][n * 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 1; k <= n - i; k++)
                sb.append(k);
            for (int j = 1; j <= (2 * (i - 1) + 1); j++)
                sb.append(" ");
            int o = n - 1 - i;
            if (i > 0)
                o++;
            for (; o >= 1; o--)
                sb.append(o);
            c[0][index++] = new StringLiteral(sb.toString());
            c[0][index++] = new NewLine();
        }
        return c;
    }
}
