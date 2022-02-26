package pre_defined_classes.mathematical_program.hard.q9;

import global.BaseTest;
import global.variables.Clause;
import global.variables.StringLiteral;
import org.junit.jupiter.api.Test;

public class GrowthRateTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The growth rate for the country is:56.25")
        };
    }

    public void runMain() {
        GrowthRate.main(new String[]{});
    }

    @Test
    public void mathTest() {
        //this test will check if the math is wrong to provide better direction to students
    }
}
