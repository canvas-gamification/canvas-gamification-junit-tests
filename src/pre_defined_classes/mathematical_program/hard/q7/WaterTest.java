package pre_defined_classes.mathematical_program.hard.q7;

import global.BaseTest;
import global.variables.Clause;
import global.variables.StringLiteral;

public class WaterTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The speed of a tsunami is 7.0km/hr")
        };
    }

    public void runMain() {
        Water.main(new String[]{});
    }

    public void mathTest(){
        //this will test if the math is wrong to provide better feedback to the student
    }
}
