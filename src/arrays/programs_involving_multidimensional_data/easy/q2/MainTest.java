package arrays.programs_involving_multidimensional_data.easy.q2;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Match"),
                new NewLine(),
                new StringLiteral("Match")
        };
    }

    public void runMain() {
        LineUps.main(new String[0]);
    }
}
