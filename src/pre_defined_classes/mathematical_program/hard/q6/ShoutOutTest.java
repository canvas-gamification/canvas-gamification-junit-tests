package pre_defined_classes.mathematical_program.hard.q6;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoutOutTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The ratio of the decibel values between a person speak and a person shouting is "),
                new DoubleLiteral(0.8749999999999999, 0.8749999999999999, "math")
        };
    }


    public void runMain() {
        ShoutOut.main(new String[]{});
    }

    @Test
    public void mathTest() {
        assertEquals("0.8749999999999999", getItemByName("math"), "Your math is incorrect");
    }
}
