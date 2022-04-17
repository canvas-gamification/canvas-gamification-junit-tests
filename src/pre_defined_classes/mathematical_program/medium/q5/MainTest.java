package pre_defined_classes.mathematical_program.medium.q5;

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
                new StringLiteral("The value of sec\\^2 is: "),
                new DoubleLiteral("sec2"),
                new NewLine(),
                new StringLiteral("The value of tan\\^2 is: "),
                new DoubleLiteral("tan2"),
                new NewLine(),
                new StringLiteral("Their difference is: "),
                new DoubleLiteral("difference")
        };
    }

    public void runMain() {
        TrigVal.main(new String[0]);
    }

    @Test
    public void correctTrigValues(){
        assertEquals(4.0, Double.parseDouble(getItemByName("sec2")), 0.001,  "The calculated value of sec^2 is incorrect.");
        assertEquals(3.0, Double.parseDouble(getItemByName("tan2")), 0.001,  "The calculated value of tan^2 is incorrect.");
        assertEquals(1.0, Double.parseDouble(getItemByName("difference")), 0.001,"The calculated difference of sec^2 - tan^2 is incorrect.");
    }
}
