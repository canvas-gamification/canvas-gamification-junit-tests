package pre_defined_classes.mathematical_program.hard.q9;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The growth rate for the country is:"),
                new DoubleLiteral("growthRate")
        };
    }

    public void runMain() {
        GrowthRate.main(new String[0]);
    }

    @Test
    public void mathTest() {
        assertEquals(56.25, Double.parseDouble(getItemByName("growthRate")), 0.01, "Growth rate calculation is incorrect. Refer back to the question for what the correct calculation should look like.");
    }
}
