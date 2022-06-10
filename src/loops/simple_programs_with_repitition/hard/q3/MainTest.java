package loops.simple_programs_with_repitition.hard.q3;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Approximation of pi using n = 10000 is "),
                new DoubleLiteral("pi")
        };
    }

    public void runMain() {
            SliceOfPi.main(new String[0]);
    }

    @Test
    void computesPiApproximationCorrectly(){
        assertEquals(Double.parseDouble(getItemByName("pi")), 3.1416926435905346, 0.0000000000000001,
                "Your program does not correctly compute the approximation of pi using the series given in the question.");
    }
}
