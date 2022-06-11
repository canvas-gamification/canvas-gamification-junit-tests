package loops.while_loops.hard.q1;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new PlaceHolder()
        };
    }

    public void runMain() {
        RevDown.main(new String[0]);
    }

    @Test
    void printsNumbersCorrectly() throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the numbers from 0 to -100 (inclusive).";
        Clause[][] c = new Clause[1][202];
        int j = 0;
        for (int i = 0; i < 202; i += 2) {
            c[0][i] = new IntegerLiteral(j);
            j--;
            c[0][i + 1] = new StringLiteral(" ");
        }
        runWithInput("", c);
    }
}
