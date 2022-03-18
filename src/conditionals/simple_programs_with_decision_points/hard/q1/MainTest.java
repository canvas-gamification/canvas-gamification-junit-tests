package conditionals.simple_programs_with_decision_points.hard.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends BaseTest {
    // Parsons with distractors
    int input = 5;
    String negativeInput = "-46";

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new IntegerLiteral(input, "returnedValue")
        };
    }

    public void runMain() {
        provideInput(String.valueOf(input));
        AbsolutelySure.main(new String[]{});
    }

    @Test
    public void negativeValueTest() {
        provideInput(negativeInput);
        AbsolutelySure.main(new String[]{});
        String output = getOutput();
        int contains = output.indexOf(negativeInput);
        assertEquals(-1, contains, "Your program does not change negative numbers to positive numbers");
    }
}
