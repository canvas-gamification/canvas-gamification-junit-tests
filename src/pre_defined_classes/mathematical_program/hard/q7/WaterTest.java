package pre_defined_classes.mathematical_program.hard.q7;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaterTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The speed of a tsunami is "),
                new DoubleLiteral(7.0, 7.0, "math"),
                new StringLiteral("km/hr")
        };
    }

    public void runMain() {
        Water.main(new String[]{});
    }

    @Test
    public void mathTest(){
        assertEquals("7.0", getItemByName("math"), "Your math is incorrect");
    }
}
