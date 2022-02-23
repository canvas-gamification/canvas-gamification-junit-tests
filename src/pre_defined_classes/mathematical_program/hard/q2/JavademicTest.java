package pre_defined_classes.mathematical_program.hard.q2;

import global.BaseTest;
import global.variables.Clause;
import global.variables.IntegerLiteral;
import global.variables.StringLiteral;

public class JavademicTest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Num cases of infections in "),
                new IntegerLiteral(30),
                new StringLiteral(" days is "),
                new StringLiteral("13099.97821824974"),
                new StringLiteral(" people")
        };
    }

    public void runMain() {
        Javademic.main(new String[0]);}
}
