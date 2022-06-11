package loops.programs_with_repetition.hard.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        return cascadingPatternClause(5);
    }

    public void runMain() {
        CascadingPattern.main(new String[0]);
    }

    private Clause[] cascadingPatternClause(int n){
        Clause[] c = new Clause[n * 2];
        int x = 0;
        int y = n;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = n; j >= n - i; j--)
                sb.append(j);
            for (int k = 1; k < n - i; k++)
                sb.append(y);
            c[x] = new StringLiteral(sb.toString());
            c[x + 1] = new NewLine();
            x += 2;
            y--;
        }
        return c;
    }
}
