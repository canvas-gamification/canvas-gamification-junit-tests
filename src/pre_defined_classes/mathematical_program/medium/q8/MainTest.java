package pre_defined_classes.mathematical_program.medium.q8;

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
                new StringLiteral("The magnitude of an earthquake with intensity "),
                new DoubleLiteral("intensity"),
                new StringLiteral(" is "),
                new DoubleLiteral("magnitude"),
                new StringLiteral(" on the Richter scale.")
        };
    }

    public void runMain() {
        Earthquake.main(new String[0]);
    }

    @Test
    public void magnitudeTest() {
        assertEquals(10.05, Double.parseDouble(getItemByName("magnitude")), 0.001, "The calculated magnitude value is incorrect.");
    }
}
