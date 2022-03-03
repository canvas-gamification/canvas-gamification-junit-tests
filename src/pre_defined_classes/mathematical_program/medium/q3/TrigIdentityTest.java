package pre_defined_classes.mathematical_program.medium.q3;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigIdentityTest extends BaseTest {
    final double cos2 = 0.2500000000000001;
    final double sin2 = 0.7499999999999999;
    final double sum = 1.0;

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The value of sin\\^2 is\\: "),
                new DoubleLiteral(0, 1.0, "sin2"),
                new NewLine(),
                new StringLiteral("The value of cos\\^2 is\\: "),
                new DoubleLiteral(0, 1.0, "cos2"),
                new NewLine(),
                new StringLiteral("Their sum is\\: "),
                new DoubleLiteral(0, 2.0, "sum")
        };
    }

    public void runMain() {
        TrigIdentity.main(new String[0]);
    }

    @Test
    public void testDoubleValues(){
        assertEquals(sin2 + "", getItemByName("sin2"), "Your value for sin^2 is incorrect");
        assertEquals(cos2 + "", getItemByName("cos2"), "Your value for cos^2 is incorrect");
        assertEquals(sum + "", getItemByName("sum"), "Your value for the sum of the angles is incorrect");
    }
}
