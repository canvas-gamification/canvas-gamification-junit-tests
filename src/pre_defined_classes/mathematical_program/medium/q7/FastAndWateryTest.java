package pre_defined_classes.mathematical_program.medium.q7;

import global.BaseRandomTest;
import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FastAndWateryTest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The speed of a tsunami starting at a depth of 5000 is "),
                new DoubleLiteral(220, 222, "waterSpeed"),
                new StringLiteral("km/hr.")
        };
    }

    public void runMain() {
        FastAndWatery.main(new String[0]);
    }

    @Test
    public void waterSpeedMathTest(){
        assertEquals(221.35943621178654 + "", getItemByName("waterSpeed"), "Your calculated water speed is incorrect");
    }
}
