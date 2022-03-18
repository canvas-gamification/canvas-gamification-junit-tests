package pre_defined_classes.mathematical_program.hard.q4;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("With tips, the amount you need to pay is: "),
                new DoubleLiteral("billAmount")
        };
    }

    public void runMain() {
        CalcBill.main(new String[]{});
    }

    @Test
    public void tipPercentageTest() {
        assertEquals(28.0, Double.parseDouble(getItemByName("billAmount")), 0.1, "Your final bill calculation is incorrect");
    }
}
