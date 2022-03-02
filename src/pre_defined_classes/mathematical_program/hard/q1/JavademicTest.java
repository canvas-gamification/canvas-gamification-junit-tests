package pre_defined_classes.mathematical_program.hard.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavademicTest extends BaseTest {
    final double xtExpected = 13099.97821824974;

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Num cases of infections in "),
                new IntegerLiteral(30),
                new StringLiteral(" days is "),
                //These are the possible range of values if they select on of the parsons distractors, and the proper
                //value is tested for below
                new DoubleLiteral(44, 1.23453340530816128E17, "xt"),
                new StringLiteral(" people")
        };
    }

    public void runMain() {
        Javademic.main(new String[0]);
    }

    @Test
    public void xtTest(){
        assertEquals(Double.parseDouble(getItemByName("xt")) , xtExpected, "Calculated value of xt is incorrect");
    }
}
