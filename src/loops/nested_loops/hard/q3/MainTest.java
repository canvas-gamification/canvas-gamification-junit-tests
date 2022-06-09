package loops.nested_loops.hard.q3;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
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
        TryAngle.main(new String[0]);
    }

    static Stream<Integer> inputProvider() {
        return Stream.of(5, 10, 4, 1);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsPatternCorrectly(int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the specified pattern correctly.";
        runWithInput(String.valueOf(n), pattern(n));
    }

    Clause[][] pattern(int n) {
        Clause[][] c = new Clause[1][n * 2];
        int k = 0;
        for (int i = 1; i <= n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 1; j <= i; j++)
                s.append(j).append(" ");
            c[0][k] = new StringLiteral(s.toString());
            c[0][k + 1] = new NewLine();
            k += 2;
        }
        return c;
    }
}
