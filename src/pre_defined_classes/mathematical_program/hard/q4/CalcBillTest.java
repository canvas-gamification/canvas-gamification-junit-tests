package pre_defined_classes.mathematical_program.hard.q4;

import global.BaseTest;
import global.variables.Clause;
import global.variables.StringLiteral;
import org.junit.jupiter.api.Test;

public class CalcBillTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("With tips, the amount you need to pay is: 28.0")
        };
    }

    public void runMain() {
        CalcBill.main(new String[]{});
    }

    @Test
    public void tipPercentageTest() {
        //this test is here for the purpose of telling the students their math is wrong, not just the formatting
    }
}
