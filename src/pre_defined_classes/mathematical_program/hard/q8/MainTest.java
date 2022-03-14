package pre_defined_classes.mathematical_program.hard.q8;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons (with distractors)
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The 7th term in the geometric sequence is: "),
                new DoubleLiteral("7thTerm"),
                new StringLiteral("E-4")
        };
    }

    public void runMain() {
        Series.main(new String[]{});
    }

    @Test
    public void testMath(){
        assertEquals(2.44140625, Double.parseDouble(getItemByName("7thTerm")), 0.1, "Your math calculation is incorrect. Try referring back to the question for what the correct calculation looks like");
    }

}
