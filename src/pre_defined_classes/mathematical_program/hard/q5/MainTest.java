package pre_defined_classes.mathematical_program.hard.q5;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The leftHandSide is "),
                new DoubleLiteral("leftSide"),
                new NewLine(),
                new StringLiteral("The rightHandSide is "),
                new DoubleLiteral("rightSide")
        };
    }

    public void runMain() {
        LeftRight.main(new String[]{});
    }

    @Test
    public void mathTest(){
        assertEquals(-0.7760683270883323, Double.parseDouble(getItemByName("leftSide")), 0.1, "Your calculations for the left hand side is incorrect");
        assertEquals(-0.7760683270883322, Double.parseDouble(getItemByName("rightSide")), 0.1, "Your calculations for the right hand side is incorrect");
    }
}
