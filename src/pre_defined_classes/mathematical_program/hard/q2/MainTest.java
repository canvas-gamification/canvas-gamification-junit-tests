package pre_defined_classes.mathematical_program.hard.q2;

import global.BaseTest;
import global.variables.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("It will take "),
                new IntegerLiteral(40, "days"),
                new StringLiteral(" days to infect "),
                new IntegerLiteral(1000000),
                new StringLiteral(" people"),
        };
    }

    public void runMain() {
        Javademic.main(new String[0]);
    }

    @Test
    public void mathTest(){
        assertEquals(getItemByName("days"), "40", "Your calculation for the number of days it takes to infect 1000000 is incorrect");
    }
}
