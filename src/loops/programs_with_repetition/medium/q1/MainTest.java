package loops.programs_with_repetition.medium.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return starPatternClause(5);
    }

    public void runMain() {
        DiamondCantBreak.main(new String[0]);
    }

    Clause[] starPatternClause(int n) {
        Clause[] c = new Clause[n * 4 - 2];
        int x = 0;
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(" ".repeat(Math.max(0, n - i)));
            sb.append("\\*".repeat(Math.max(0, i)));
            c[x] = new StringLiteral(sb.toString());
            c[x + 1] = new NewLine();
            x += 2;
        }
        for (int i = 1; i <= n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(" ".repeat(Math.max(0, i)));
            sb.append("\\*".repeat(Math.max(0, n - i)));
            c[x] = new StringLiteral(sb.toString());
            c[x + 1] = new NewLine();
            x += 2;
        }
        return c;
    }
}
