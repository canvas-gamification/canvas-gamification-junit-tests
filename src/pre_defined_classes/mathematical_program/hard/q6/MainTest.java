package pre_defined_classes.mathematical_program.hard.q6;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The ratio of the decibel values between a person speak and a person shouting is "),
                new DoubleLiteral("ratio")
        };
    }


    public void runMain() {
        ShoutOut.main(new String[0]);
    }

    @Test
    public void mathTest() {
        assertEquals(0.875, Double.parseDouble(getItemByName("ratio")), 0.001, "Your ratio calculation is incorrect.");
    }
}
