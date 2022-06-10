package loops.programs_with_repetition.easy.q2;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return patternClause(5);
    }

    public void runMain() {
        PatteringDown.main(new String[0]);
    }

    static Clause[] patternClause(int n){
        Clause[]c = new Clause[n * 2];
        int x = 1;
        int j = 0;
        for (int i = 1; i <= 5; i++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 1; k <= i; k++)
                sb.append(String.valueOf(x++));
            c[j] = new StringLiteral(sb.toString());
            c[j + 1] = new NewLine();
            j += 2;
        }
        return c;
    }
}
