package loops.nested_loops.hard.q2;

import global.BaseTest;

import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return repeatPatternClause(4);
    }

    public void runMain() {
        RepeatTheRepeat.main(new String[0]);
    }

    private Clause[] repeatPatternClause(int n) {
        Clause[] c = new Clause[n * 2];
        int x = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                sb.append(j).append(" ");
            }
            c[x] = new StringLiteral(sb.toString());
            c[x + 1] = new NewLine();
            x += 2;
        }
        return c;
    }

}
