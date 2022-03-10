package pre_defined_classes.programs_with_changing_behaviour.hard.q2;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

import static org.junit.jupiter.api.Assertions.fail;

public class MainTest extends BaseRandomTest {
    //Parsons with Distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new RandomInteger(10000000, 100000000),
                new StringLiteral(" has been decrypted using "),
                new RandomInteger(1, 10),
                new StringLiteral(" into "),
                new IntegerLiteral(1000000, 100000000)
        };
    }

    public void runMain() {
        DeCryptic.main(new String[0]);
    }

}
