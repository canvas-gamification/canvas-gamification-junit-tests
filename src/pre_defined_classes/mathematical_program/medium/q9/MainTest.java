package pre_defined_classes.mathematical_program.medium.q9;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The left hand side is "),
                new DoubleLiteral("LHS"),
                new NewLine(),
                new StringLiteral("The right hand side is "),
                new DoubleLiteral("RHS")
        };
    }

    public void runMain() {
        TrigIdentity.main(new String[0]);
    }

    @Test
    public void outputTest(){
        double rightSide = Double.parseDouble(getItemByName("RHS"));
        double leftSide = Double.parseDouble(getItemByName("LHS"));
        assertEquals(0.53, leftSide, 0.1, "The left hand side has been calculated incorrectly");
        assertEquals(0.53, rightSide, 0.1, "The right hand side has been calculated incorrectly");
        assertEquals(rightSide, leftSide, 0.1, "The right hand side does not equal the left hand side");
    }
}
