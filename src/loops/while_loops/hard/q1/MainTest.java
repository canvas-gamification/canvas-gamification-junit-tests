package loops.while_loops.hard.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        Clause[] c = new Clause[202];
        int j = 0;
        for(int i = 0; i < 202; i+=2){
            c[i] = new IntegerLiteral(j);
            j--;
            c[i + 1] = new StringLiteral(" ");
        }
        return c;
    }

    public void runMain() {
        RevDown.main(new String[0]);
    }
}
