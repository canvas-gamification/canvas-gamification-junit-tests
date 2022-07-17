package loops.programs_with_repetition.hard.q7;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence(){
        TestOption.isInputTest = false;
        return new Clause[]{
                new StringLiteral("Approximation of sin\\("),
                new DoubleLiteral("x"),
                new StringLiteral("\\) using n = "),
                new IntegerLiteral("n"),
                new StringLiteral(" is "),
                new DoubleLiteral("approx")
        };
    }

    public void runMain(){SinOfTheTimes.main(new String[0]);}

    @Test
    void correctApproximationCalculated(){
        assertEquals(3.14, Double.parseDouble(getItemByName("x")), "You are not using the correct x value.");
        assertEquals(10, Integer.parseInt(getItemByName("n")), "You are not using the correct n value");
        assertEquals(-49.00946626850902, Double.parseDouble(getItemByName("approx")), "Your approximation was incorrect.");
    }
}
