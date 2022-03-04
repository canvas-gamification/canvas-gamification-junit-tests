package pre_defined_classes.mathematical_program.hard.q9;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrowthRateTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The growth rate for the country is:"),
                new DoubleLiteral(56.25, 56.25, "math")
        };
    }

    public void runMain() {
        GrowthRate.main(new String[]{});
    }

    @Test
    public void mathTest() {
        assertEquals("56.25", getItemByName("math"));
    }
}
