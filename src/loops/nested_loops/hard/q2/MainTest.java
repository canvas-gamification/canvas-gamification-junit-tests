package loops.nested_loops.hard.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new PlaceHolder()
        };
    }

    public void runMain() {
        RepeatTheRepeat.main(new String[0]);
    }

    @Test
    void printsPatternCorrectly() throws InvalidClauseException {
        int n = 4;
        Clause[][] c = new Clause[1][n * 2];
        int x = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                sb.append(j).append(" ");
            }
            c[0][x] = new StringLiteral(sb.toString());
            c[0][x + 1] = new NewLine();
            x += 2;
        }
        runWithInput("", c);
    }
}
