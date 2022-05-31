package pre_defined_classes.programs_with_changing_behaviour.hard.q4;

import global.BaseRandomTest;
import global.exceptions.InvalidClauseException;
import global.exceptions.InvalidTestOptionException;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Random Passcode: "),
                new RandomInteger(0, 10, "n1"),
                new StringLiteral(" "),
                new RandomInteger(0, 10, "n2"),
                new StringLiteral(" "),
                new RandomInteger(0, 10, "n3"),
                new StringLiteral(" "),
                new RandomInteger(0, 10, "n4"),
                new StringLiteral(" "),
                new RandomInteger(0, 10, "n5"),
                new StringLiteral(" "),
                new RandomInteger(0, 10, "n6")
        };
    }

    public void runMain() {
        PassCode.main(new String[0]);
    }

    /* Runs until either numbers are not equal or numbers have been equal 10 times to make sure students use
    different random numbers.
     */
    @Test
    public void generatedNumbersAreIndependent() throws InvalidClauseException, InvalidTestOptionException {
        int n1, n2, n3, n4, n5, n6;
        // Keeps track of how many times all digits of the passcode are equal to each other. If more than 10, test fails
        int independentNumbers = 0;
        do {
            setUp();
            n1 = Integer.parseInt(getItemByName("n1"));
            n2 = Integer.parseInt(getItemByName("n2"));
            n3 = Integer.parseInt(getItemByName("n3"));
            n4 = Integer.parseInt(getItemByName("n4"));
            n5 = Integer.parseInt(getItemByName("n5"));
            n6 = Integer.parseInt(getItemByName("n6"));
            independentNumbers++;
            if (independentNumbers >= 10)
                fail("Your program does not randomly generated numbers that are independent (not always equal).");
        } while (n1 == n2 && n1 == n3 && n1 == n4 && n1 == n5 && n1 == n6);
    }

}
