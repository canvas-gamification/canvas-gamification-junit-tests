package pre_defined_classes.mathematical_program.hard;

import global.BaseTest;
import global.variables.Clause;
import global.variables.IntegerLiteral;
import global.variables.StringLiteral;

public class Question2Test extends BaseTest {
    @Override
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Num cases of infections in "),
                new IntegerLiteral(30),
                new StringLiteral(" days is "),
                new StringLiteral("13099.97821824974"),
                new StringLiteral(" people")
        };
    }

    @Override
    public void runMain() {Question2.main(new String[0]);}
}
