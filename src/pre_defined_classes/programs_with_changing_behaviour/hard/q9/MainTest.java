package pre_defined_classes.programs_with_changing_behaviour.hard.q9;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseRandomTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The first die rolled is a "),
                new RandomInteger(1, 7, "firstRoll"),
                new StringLiteral("\\."),
                new NewLine(),
                new StringLiteral("The second die rolled is a "),
                new RandomInteger(1, 7, "secondRoll"),
                new StringLiteral("\\."),
                new NewLine(),
                new StringLiteral("Your new position is: "),
                new IntegerLiteral("position")
        };
    }

    public void runMain() {
        Monopoly.main(new String[0]);
    }

    @RepeatedTest(10)
    void calculatesNewPositionCorrectly() {
        int position = 46 + Integer.parseInt(getItemByName("firstRoll")) + Integer.parseInt(getItemByName("secondRoll"));
        assertEquals(position, Integer.parseInt(getItemByName("position")), "Your program does not correctly calculate your new position on the monopoly board based on the dice rolls.");
    }
}
