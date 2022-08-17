package pre_defined_classes.programs_with_changing_behaviour.medium.q10;

import org.junit.jupiter.api.Test;

import global.BaseRandomTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[] {
                new StringLiteral("Turn 1: "),
                new RandomInteger(0, 2, "firstToss"),
                new NewLine(),
                new StringLiteral("Turn 2: "),
                new RandomInteger(0, 2, "secondToss"),
                new NewLine(),
                new StringLiteral("Turn 3: "),
                new RandomInteger(0, 2, "thirdToss"),
                new NewLine(),
                new StringLiteral("Player 1 won "),
                new IntegerLiteral("timesPlay1Won"),
                new StringLiteral(" out of the 3 rounds")
        };
    }

    public void runMain() {
        HeadsTails.main(new String[0]);
    }

    @Test
    public void totalNumberPlayerWon() {
        int firstToss = Integer.parseInt(getItemByName("firstToss"));
        int secondToss = Integer.parseInt(getItemByName("secondToss"));
        int thirdToss = Integer.parseInt(getItemByName("thirdToss"));
        int timesPlay1Won = Integer.parseInt(getItemByName("timesPlay1Won"));
        int expectedTimesPlay1Won = firstToss + secondToss + thirdToss;

        CustomAssertions._assertEquals(expectedTimesPlay1Won, timesPlay1Won,
                "Your program does not prints the correct number of times Player 1 won.");
    }
}
