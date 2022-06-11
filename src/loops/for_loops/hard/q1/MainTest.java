package loops.for_loops.hard.q1;

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
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print out the numbers from 0 to -100 (inclusive).";
        Clause[][] numbersToNegative100 = new Clause[1][202];
        int value = 0;
        for (int i = 0; i < numbersToNegative100[0].length; i += 2) {
            numbersToNegative100[0][i] = new IntegerLiteral(value);
            value--;
            numbersToNegative100[0][i + 1] = new StringLiteral(" ");
        }
        runWithInput("", numbersToNegative100);
    }

}
