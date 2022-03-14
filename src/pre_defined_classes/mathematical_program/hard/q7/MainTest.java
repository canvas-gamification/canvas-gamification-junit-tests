package pre_defined_classes.mathematical_program.hard.q7;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons (with distractors)
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The speed of a tsunami is "),
                new DoubleLiteral("speed"),
                new StringLiteral("km/hr")
        };
    }

    public void runMain() {
        Water.main(new String[]{});
    }

    @Test
    public void mathTest(){
        assertEquals(7.0, Double.parseDouble(getItemByName("speed")), 0.1, "Your speed calculation is incorrect. Try referring back to the question for what the correct calculation should look like");
    }
}
