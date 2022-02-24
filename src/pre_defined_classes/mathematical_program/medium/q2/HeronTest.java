package pre_defined_classes.mathematical_program.medium.q2;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;

public class HeronTest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The area of the triangle is: 8.317902379807064 units squared.")
        };
    }

    public void runMain() {
        Heron.main(new String[0]);
    }
}
