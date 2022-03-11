package pre_defined_classes.mathematical_program.medium.q3;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    //Parsons
    final double cos2 = 0.25;
    final double sin2 = 0.75;
    final double sum = 1.0;

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The value of sin\\^2 is: "),
                new DoubleLiteral("sin2"),
                new NewLine(),
                new StringLiteral("The value of cos\\^2 is: "),
                new DoubleLiteral( "cos2"),
                new NewLine(),
                new StringLiteral("Their sum is: "),
                new DoubleLiteral("sum")
        };
    }

    public void runMain() {
        TrigIdentity.main(new String[0]);
    }

    @Test
    public void testDoubleValues(){
        assertEquals(sin2 , Double.parseDouble(getItemByName("sin2")), 0.05, "Your value for sin^2 is incorrect");
        assertEquals(cos2 , Double.parseDouble(getItemByName("cos2")), 0.05,  "Your value for cos^2 is incorrect");
        assertEquals(sum , Double.parseDouble(getItemByName("sum")), 0.05, "Your value for the sum of the angles is incorrect");
    }
}
