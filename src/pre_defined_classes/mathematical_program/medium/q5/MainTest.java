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
                new StringLiteral("The value of tan\\^2 is: "),
                new DoubleLiteral(2, 4, "tan2"),
                new NewLine(),
                new StringLiteral("The value of sec\\^2 is: "),
                new DoubleLiteral(3, 5, "sec2"),
                new NewLine(),
                new StringLiteral("Their sum is: "),
                new DoubleLiteral(6, 8, "sum")
        };
    }

    public void runMain() {
        TrigVal.main(new String[0]);
    }

    @Test
    public void trigDoubleValueTest(){
        assertEquals(3.0, Double.parseDouble(getItemByName("tan2")), 0.1,  "Calculated value of tan^2 is incorrect");
        assertEquals(4.0, Double.parseDouble(getItemByName("sec2")), 0.1,  "Calculated value of sec^2 is incorrect");
        assertEquals(7.0, Double.parseDouble(getItemByName("sum")), 0.1,"Calculated sum of tan^2 + sec^2 is incorrect");
    }
}
