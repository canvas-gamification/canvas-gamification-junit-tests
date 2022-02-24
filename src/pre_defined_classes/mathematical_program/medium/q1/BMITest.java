package pre_defined_classes.mathematical_program.medium.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

public class BMITest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The BMI of a person that weighs 70.5 kilograms and is 1.63 metres tall is: 26.53468327750386")
        };
    }

    public void runMain() {
        BMI.main(new String[0]);
    }
}
