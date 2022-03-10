package pre_defined_classes.mathematical_program.hard.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    //Parsons with distractors
    final double xtExpected = 13100.00;

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Num cases of infections in "),
                new IntegerLiteral(30),
                new StringLiteral(" days is "),
                new DoubleLiteral( "xt"),
                new StringLiteral(" people")
        };
    }

    public void runMain() {
        Javademic.main(new String[0]);
    }

    @Test
    public void xtTest(){
        assertEquals(Double.parseDouble(getItemByName("xt")) , xtExpected, 0.5, "Calculated value of xt is incorrect");
    }
}
