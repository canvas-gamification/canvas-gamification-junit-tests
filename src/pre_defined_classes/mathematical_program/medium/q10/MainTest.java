package pre_defined_classes.mathematical_program.medium.q10;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    //Parsons

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The amount owing is "),
                new DoubleLiteral("amountOwed"),
                new StringLiteral(" dollars.")
        };
    }

    public void runMain() {
        Compounding.main(new String[0]);
    }

    @Test
    public void outputTest(){
        assertEquals(7764.85, Double.parseDouble(getItemByName("amountOwed")), 0.05, "Calculated amount owed is incorrect");
    }
}
