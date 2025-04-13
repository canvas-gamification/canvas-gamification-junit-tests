package conditionals.nested_statements.q11;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
    // Parsons
    private final String answer = "Chili";
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral(answer)
        };
    }

    public void runMain() {
        FruitIdentifier.main(new String[0]);
    }

    @Test
    public void IdentifierTest() {
        assertEquals(answer, getOutput(), "The printed item is incorrect for the given color and taste.");
    }
}

