package pre_defined_classes.mathematical_program.medium.q2;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    final double area = 8.317902379807064;

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The area of the triangle is: "),
                new DoubleLiteral("area"),
                new StringLiteral(" units squared.")
        };
    }

    public void runMain() {
        Heron.main(new String[0]);
    }

    @Test
    public void areaTest(){
        assertEquals(Double.parseDouble(getItemByName("area")), area, 0.2, "Calculated area is incorrect, try again.");
    }
}
