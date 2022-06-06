package loops.for_loops.hard.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        Clause[] numbersToNegative100 = new Clause[202];
        int value = 0;
        for(int i = 0; i < numbersToNegative100.length; i += 2) {
            numbersToNegative100[i] = new IntegerLiteral(value);
            value--;
            numbersToNegative100[i + 1] = new StringLiteral(" ");
        }
        return numbersToNegative100;
    }

    public void runMain() {
        RevDown.main(new String[0]);
    }

}
