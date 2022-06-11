package loops.programs_with_repetition.medium.q3;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        return pantsPattern(5);
    }

    public void runMain() {
        ThisPatternLooksLikePants.main(new String[0]);
    }

    private Clause[] pantsPattern(int n) {
        Clause[] c = new Clause[n * 2];
        int x = 0;
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
            c[x] = new StringLiteral(sb.toString());
            c[x + 1] = new NewLine();
            x += 2;
        }
        return c;
    }
}
