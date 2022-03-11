package pre_defined_classes.mathematical_program.hard.q9;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    //Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The growth rate for the country is:"),
                new DoubleLiteral("math")
        };
    }

    public void runMain() {
        GrowthRate.main(new String[]{});
    }

    @Test
    public void mathTest() {
        assertEquals(56.25, Double.parseDouble(getItemByName("math")), 0.1, "Math is incorrect");
    }
}
