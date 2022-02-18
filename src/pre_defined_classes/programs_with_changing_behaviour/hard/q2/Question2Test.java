package pre_defined_classes.programs_with_changing_behaviour.hard.q2;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.RandomInteger;
import global.variables.StringLiteral;

public class Question2Test extends BaseRandomTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new RandomInteger(10000000 , 100000000),
                new StringLiteral(" has been decrypted using "),
                new RandomInteger(1, 10),
                new StringLiteral(" into "),
                //don't know how to extract this part from output
        };
    }

    public void runMain() {
        Question2.main(new String[0]);}

}
