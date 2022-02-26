package pre_defined_classes.mathematical_program.hard.q8;

import global.BaseTest;
import global.variables.Clause;
import global.variables.StringLiteral;
import org.junit.jupiter.api.Test;

public class SeriesTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The 7th term in the geometric sequence is: 2.44140625E-4")
        };
    }

    public void runMain() {
        Series.main(new String[]{});
    }

    @Test
    public void mathTest() {
        //this test will check if the math is wrong, not just the formatting, to provide a more accurate error message
    }
}
