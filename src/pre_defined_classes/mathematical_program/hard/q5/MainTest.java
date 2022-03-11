package pre_defined_classes.mathematical_program.hard.q5;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    //parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The leftHandSide is -"),
                new DoubleLiteral("left"),
                new NewLine(),
                new StringLiteral("The rightHandSide is -"),
                new DoubleLiteral("right")
        };
    }

    public void runMain() {
        LeftRight.main(new String[]{});
    }

    @Test
    public void mathTest(){
        assertEquals(-0.7760683270883323, Double.parseDouble(getItemByName("left"))*-1, 0.1, "The left hand side is calculated incorrectly");
        assertEquals(-0.7760683270883322, Double.parseDouble(getItemByName("right"))*-1, 0.1, "The right hand side is calculated incorrectly");
    }
}
