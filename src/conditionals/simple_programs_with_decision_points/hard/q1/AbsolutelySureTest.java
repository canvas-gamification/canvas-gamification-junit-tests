package conditionals.simple_programs_with_decision_points.hard.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbsolutelySureTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new IntegerLiteral(5, "returnedValue")
        };
    }

    public void runMain() {
        provideInput("5");
        AbsolutelySure.main(new String[]{});
    }

    @Test
    public void negativeValueTest() {
        provideInput("-46");
        AbsolutelySure.main(new String[]{});
        String output = getOutput();
        int contains = output.indexOf("-46");
        assertEquals(-1, contains, "Your program does not change negative numbers to positive numbers");
    }
}
