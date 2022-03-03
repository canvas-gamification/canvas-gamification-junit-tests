package pre_defined_classes.mathematical_program.medium.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BMITest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The BMI of a person that weighs "),
                new DoubleLiteral(70.5, 70.5),
                new StringLiteral(" kilograms and is "),
                new DoubleLiteral(1.63, 1.63),
                new StringLiteral(" metres tall is: "),
                new DoubleLiteral(26, 27, "BMI")
        };
    }

    public void runMain() {
        BMI.main(new String[0]);
    }

    @Test
    public void BMIValueTest(){
        assertEquals(26.53468327750386 + "", getItemByName("BMI").trim(), "Calculated value of BMI is incorrect");
    }
}
