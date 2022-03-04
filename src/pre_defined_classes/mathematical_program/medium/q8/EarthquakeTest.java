package pre_defined_classes.mathematical_program.medium.q8;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EarthquakeTest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The magnitude of an earthquake with intensity "),
                new DoubleLiteral(23200.0, 23200.0, "intensity"),
                new StringLiteral(" is "),
                new DoubleLiteral(10, 11, "magnitude"),
                new StringLiteral(" on the Richter scale.")
        };
    }

    public void runMain() {
        Earthquake.main(new String[0]);
    }

    @Test
    public void magnitudeTest(){
        assertEquals("" + 10.0519075576544, getItemByName("magnitude"), "The calculated magnitude value is incorrect");
    }
}
