package pre_defined_classes.mathematical_program.medium.q1;

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
                new StringLiteral("The BMI of a person that weighs "),
                new DoubleLiteral("weight"),
                new StringLiteral(" kilograms and is "),
                new DoubleLiteral("height"),
                new StringLiteral(" metres tall is: "),
                new DoubleLiteral("BMI")
        };
    }

    public void runMain() {
        BMI.main(new String[0]);
    }

    @Test
    public void BMIValueTest() {
        double bmi = Double.parseDouble(getItemByName("weight")) / Math.pow(Double.parseDouble(getItemByName("height")), 2);
        assertEquals(Double.parseDouble(getItemByName("BMI")), bmi, 0.01, "The value of BMI has been calculated incorrectly.");
    }
}
