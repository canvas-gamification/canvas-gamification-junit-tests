package pre_defined_classes.mathematical_program.medium.q6;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("A person speaking is "),
                new DoubleLiteral("decibels"),
                new StringLiteral(" decibels loud!")
        };
    }

    public void runMain() {
        SoundsGood.main(new String[0]);
    }

    @Test
    public void decibelMathTest(){
        assertEquals( 161.181, Double.parseDouble(getItemByName("decibels")), 0.01,"The calculated decibel value is incorrect.");
    }

}
