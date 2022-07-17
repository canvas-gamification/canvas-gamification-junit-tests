package loops.programs_with_repetition.hard.q7;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence(){
        TestOption.isInputTest = false;
        return new Clause[]{
                new StringLiteral("Approximation of sin\\("),
                new DoubleLiteral("x"),
                new StringLiteral("\\) using n = "),
                new IntegerLiteral("num"),
                new StringLiteral(" is "),
                new DoubleLiteral("approx")
        };
    }

    public void runMain(){SinOfTheTimes.main(new String[0]);}
}
