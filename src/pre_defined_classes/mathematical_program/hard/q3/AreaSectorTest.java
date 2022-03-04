package pre_defined_classes.mathematical_program.hard.q3;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaSectorTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The area of the sector is: "),
                new DoubleLiteral(24.801128670839425, 24.801128670839425, "math")
        };
    }

    public void runMain() {
        AreaSector.main(new String[]{});
    }

    @Test
    public void mathTest() {
        assertEquals("24.801128670839425", getItemByName("math"), "Your program's math calculations are incorrect");
    }
}