package loops.programs_with_repetition.easy.q3;

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
        Pattern.main(new String[0]);
    }

    static Clause[] starPatternClause(int n){
        Clause[] c = new Clause[n * 2];
        int j = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(" ".repeat(i + 1));
            sb.append("\\*".repeat(5 - i));
            c[j] = new StringLiteral(sb.toString());
            c[j + 1] = new NewLine();
            j += 2;
        }
        return c;
    }
}
