package pre_defined_classes.mathematical_program.hard.q2;

import global.BaseTest;
import global.variables.*;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("It will take "),
                new IntegerLiteral("days"),
                new StringLiteral(" days to infect "),
                new IntegerLiteral("people"),
                new StringLiteral(" people"),
        };
    }

    public void runMain() {
        Javademic.main(new String[0]);
    }

    @Test
    public void mathTest(){
        assertEquals(getItemByName("days"), "40", "Your calculation for the number of days it takes to infect 1000000 is incorrect");
        assertEquals(getItemByName("people"), "1000000", "The number of people infected is wrong");
    }
}
