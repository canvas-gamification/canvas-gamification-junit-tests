package pre_defined_classes.mathematical_program.hard.q3;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons (with distractors)
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The area of the sector is: "),
                new DoubleLiteral("area")
        };
    }

    public void runMain() {
        AreaSector.main(new String[0]);
    }

    @Test
    public void mathTest() {
        assertEquals(24.801128670839425, Double.parseDouble(getItemByName("area")), 0.1, "Your program's math calculations are incorrect");
    }
}
