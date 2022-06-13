package loops.programs_with_repetition.hard.q2;

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
        TestOption.defaultInput = "1";
        return new Clause[]{
                new StringLiteral("Enter the number of lines:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        Replication.main(new String[0]);
    }

    static Stream<Integer> inputProvider() {
        return Stream.of(5, 0, -1, 14);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsPatternCorrectly(int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the pattern correctly based on the input N.";
        Clause[][] c;
        if (n < 0)
            c = new Clause[][]{{new StringLiteral("")}};
        else {
            c = new Clause[1][n * 2];
            int x = 0;
            String s = "A";
            for (int i = 0; i < n; i++) {
                c[0][x] = new StringLiteral(s);
                c[0][x + 1] = new NewLine();
                x += 2;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == 'A')
                        sb.append("BA");
                    else
                        sb.append("AA");
                }
                s = sb.toString();
            }
        }
        runWithInput(String.valueOf(n), c);
    }
}
