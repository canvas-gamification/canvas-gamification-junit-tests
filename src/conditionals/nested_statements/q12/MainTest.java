package conditionals.nested_statements.q12;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {

    private final String line1 = "Odd Score";
    private final String line2 = "Good";

    public Clause[] testSentence() {
        return new Clause[]{
            new StringLiteral(line1),
            new NewLine(),
            new StringLiteral(line2)
        };
    }

    public void runMain() {
        ScoreAnalyzer.main(new String[0]);
    }

    @Test
    public void ScoreAnalyzeTest() {
        String expected = line1 + System.lineSeparator() + line2 + System.lineSeparator();
        assertEquals(expected, getOutput(), "The output for score evaluation is incorrect.");
    }
}