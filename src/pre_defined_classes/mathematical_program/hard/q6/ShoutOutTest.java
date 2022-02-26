package pre_defined_classes.mathematical_program.hard.q6;

import global.BaseTest;
import global.variables.Clause;
import global.variables.StringLiteral;

public class ShoutOutTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The ratio of the decibel values between a person speak and a person shouting is 0.8749999999999999"),
        };
    }

    public void runMain() {
        ShoutOut.main(new String[]{});
    }

    public void mathTest(){
        //this test will be to check if the math is wrong to give a clearer error message
    }
}
