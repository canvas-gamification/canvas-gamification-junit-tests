package loops.nested_loops.q5;

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
        TestOption.defaultInput = "1";
        return new Clause[]{
                new StringLiteral("Enter the number of lines:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        TryAngleButReflected.main(new String[0]);
    }

    static Stream<Integer> inputProvider(){
        return Stream.of(0, 1, 8, 49, -1);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsPatternCorrectly(int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the pattern based on the integer input n.";
        runWithInput(String.valueOf(n), pattern(n));
    }

    static Clause[][] pattern(int n){
        if(n <= 0)
            return new Clause[][]{{new StringLiteral("")}};
        Clause[][] c = new Clause[1][n * 2];
        int k = 0;
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= (n - i + 1); j++)
                sb.append(j).append(" ");
            c[0][k] = new StringLiteral(sb.toString());
            c[0][k + 1] = new NewLine();
            k += 2;
        }
        return c;
    }
}
