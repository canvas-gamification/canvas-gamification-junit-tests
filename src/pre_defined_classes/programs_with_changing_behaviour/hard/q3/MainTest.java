package pre_defined_classes.programs_with_changing_behaviour.hard.q3;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomChar;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseRandomTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Random Postal Code: "),
                new RandomChar('A', 'G', "c1"),
                new RandomInteger(0, 10, "n1"),
                new RandomChar('A', 'G', "c2"),
                new RandomInteger(0, 10, "n2"),
                new RandomChar('A', 'G', "c3"),
                new RandomInteger(0, 10, "n3")
        };
    }

    public void runMain() {
        PostalCode.main(new String[0]);
    }

}
