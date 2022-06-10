package loops.programs_with_repetition.easy.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return clausePattern(5);
    }

    public void runMain() {
        PityPattern.main(new String[0]);
    }

    Clause[] clausePattern(int n){
        Clause[] c = new Clause[n * 2];
        int j = 0;
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 1; k <= i; k++)
                sb.append(i);
            c[j] = new StringLiteral(sb.toString());
            c[j + 1] = new NewLine();
            j += 2;
        }
        return c;
    }
}
