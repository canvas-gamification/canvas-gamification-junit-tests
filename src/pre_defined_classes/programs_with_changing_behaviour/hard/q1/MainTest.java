package pre_defined_classes.programs_with_changing_behaviour.hard.q1;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseRandomTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new RandomInteger(10000000, 100000000, "crypt"),
                new StringLiteral(" has been encrypted using "),
                new RandomInteger(1, 10, "key"),
                new StringLiteral(" into "),
                new IntegerLiteral("encrypt")
        };
    }

    public void runMain() {
        Cryptic.main(new String[0]);
    }

    @Test
    public void encryptsNumbersCorrectly() {
        int crypt = Integer.parseInt(getItemByName("crypt"));
        int key = Integer.parseInt(getItemByName("key"));
        int encrypt = Integer.parseInt(getItemByName("encrypt"));
        assertEquals(crypt * key, encrypt, "The calculated value of encrypt value is incorrect.");
    }

}
