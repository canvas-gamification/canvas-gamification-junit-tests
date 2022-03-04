package pre_defined_classes.mathematical_program.medium.q6;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoundsGoodTest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("A person speaking is "),
                new DoubleLiteral(160, 162, "decibels"),
                new StringLiteral(" decibels loud!")
        };
    }

    public void runMain() {
        SoundsGood.main(new String[0]);
    }

    @Test
    public void decibelMathTest(){
        assertEquals("" + 161.1809565095832, getItemByName("decibels"), "Your decibel value is incorrect");
    }

}
