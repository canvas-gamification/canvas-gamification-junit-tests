package conditionals.simple_programs_with_decision_points.medium.q1;

/*
Write a program that will ask the user for their investment and double it if it is above $5000
 */

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class InvestOpTest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("What is your investment in $ (rounded to the nearest dollar)? "),
                new NewLine(),
                new StringLiteral("Investment : "),
                new IntegerLiteral(5000)
        };
    }

    public void runMain() {
        provideInput("" + 5000);
        InvestOp.main(new String[0]);
    }
}
