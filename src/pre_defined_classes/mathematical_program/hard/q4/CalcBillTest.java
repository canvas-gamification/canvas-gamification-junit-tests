package pre_defined_classes.mathematical_program.hard.q4;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcBillTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("With tips, the amount you need to pay is: "),
                new DoubleLiteral(4.0,28.0, "math")
        };
    }

    public void runMain() {
        CalcBill.main(new String[]{});
    }

    @Test
    public void tipPercentageTest() {
        assertEquals("28.0", getItemByName("math"), "Your math is incorrect");
    }
}
