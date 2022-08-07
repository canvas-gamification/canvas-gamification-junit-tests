package pre_defined_classes.programs_with_changing_behaviour.medium.q8;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Your first throw scored "),
                new RandomInteger(0, 21, "firstThrow"),
                new StringLiteral(" points\\."),
                new NewLine(),
                new StringLiteral("Your second throw scored "),
                new RandomInteger(0, 21, "secondThrow"),
                new StringLiteral(" points\\."),
                new NewLine(),
                new StringLiteral("Your third throw scored "),
                new RandomInteger(0, 21, "thirdThrow"),
                new StringLiteral(" points\\."),
                new NewLine(),
                new StringLiteral("Nice! You scored "),
                new IntegerLiteral(0, 21, "score"),
                new StringLiteral(" points this round!")
        };
    }

    public void runMain() {
        Darts.main(new String[0]);
    }

    @RepeatedTest(10)
    void calculatesScoreCorrectly() {
        int throw1 = Integer.parseInt(getItemByName("firstThrow"));
        int throw2 = Integer.parseInt(getItemByName("secondThrow"));
        int throw3 = Integer.parseInt(getItemByName("thirdThrow"));
        int score = Math.max(Math.max(throw1, throw2), throw3);
        assertEquals(score, Integer.parseInt(getItemByName("score")), "Your program does not correctly compute the score for the round.");
    }
}
