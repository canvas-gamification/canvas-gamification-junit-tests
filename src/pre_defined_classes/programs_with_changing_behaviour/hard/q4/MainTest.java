package pre_defined_classes.programs_with_changing_behaviour.hard.q4;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors
    private static int independentNumbers;      // Keeps track of how many times all digits of the passcode are equal to each other

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

//    @RepeatedTest(50)
//    public void generatedNumbersAreIndependentOLD() {           // Independent Numbers Workaround
//        int n1 = Integer.parseInt(getItemByName("n1"));
//        int n2 = Integer.parseInt(getItemByName("n2"));
//        int n3 = Integer.parseInt(getItemByName("n3"));
//        int n4 = Integer.parseInt(getItemByName("n4"));
//        int n5 = Integer.parseInt(getItemByName("n5"));
//        int n6 = Integer.parseInt(getItemByName("n6"));
//        if (n1 == n2 && n1 == n3 && n1 == n4 && n1 == n5 && n1 == n6) {
//            independentNumbers++;
//        }
//        if (independentNumbers >= 30) {
//            fail("Make sure your randomly generated numbers are independent (not always equal).");
//        }
//    }

    @Test
    public void generatedNumbersAreIndependent() {
        int n1, n2, n3, n4, n5, n6;
        do {
            runMain();
            n1 = Integer.parseInt(getItemByName("n1"));
            n2 = Integer.parseInt(getItemByName("n2"));
            n3 = Integer.parseInt(getItemByName("n3"));
            n4 = Integer.parseInt(getItemByName("n4"));
            n5 = Integer.parseInt(getItemByName("n5"));
            n6 = Integer.parseInt(getItemByName("n6"));
            independentNumbers++;
            if (independentNumbers >= 15)
                fail("Make sure your randomly generated numbers are independent (not always equal).");
        } while (n1 == n2 && n1 == n3 && n1 == n4 && n1 == n5 && n1 == n6);
    }

}
