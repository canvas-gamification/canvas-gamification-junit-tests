package pre_defined_classes.mathematical_program.medium.q5;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigValTest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The value of tan\\^2 is\\: "),
                new DoubleLiteral(2, 4, "tan2"),
                new NewLine(),
                new StringLiteral("The value of sec\\^2 is\\: "),
                new DoubleLiteral(3, 5, "sec2"),
                new NewLine(),
                new StringLiteral("Their sum is\\: "),
                new DoubleLiteral(6, 8, "sum")
        };
    }

    public void runMain() {
        TrigVal.main(new String[0]);
    }

    @Test
    public void trigDoubleValueTest(){
        assertEquals(2.9999999999999982 + "", getItemByName("tan2"), "Calculated value of tan^2 is incorrect");
        assertEquals(3.9999999999999982 + "", getItemByName("sec2"), "Calculated value of sec^2 is incorrect");
        assertEquals(6.9999999999999964 + "", getItemByName("sum"), "Calculated sum of tan^2 + sec^2 is incorrect");
    }
}
