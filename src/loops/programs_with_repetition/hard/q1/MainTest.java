package loops.programs_with_repetition.hard.q1;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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
        CascadingPattern.main(new String[0]);
    }

    static Stream<Integer> validInputProvider() {
        return Stream.of(5, 0, 1, 11, 359);
    }

    static Stream<Integer> invalidInputProvider() {
        return Stream.of(-1, -2, -10, -24453);
    }

    @ParameterizedTest
    @MethodSource("validInputProvider")
    void printsCascadingPatternCorrectly(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the cascading pattern correctly.";
        runWithInput(String.valueOf(input), clauseBuilder(input));
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void printsErrorMessageForInvalidInput(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print an error message for invalid input.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral("Invalid input!")
        });
    }

    private static Clause[][] clauseBuilder(int length) {
        Clause[][] c = new Clause[1][length * 2];
        int n = length;
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = length; j >= length - i; j--)
                sb.append(j);
            for (int k = 1; k < length - i; k++)
                sb.append(n);
            c[0][i * 2] = new StringLiteral(sb.toString());
            c[0][i * 2 + 1] = new NewLine();
            n--;
        }
        return c;
    }
}
