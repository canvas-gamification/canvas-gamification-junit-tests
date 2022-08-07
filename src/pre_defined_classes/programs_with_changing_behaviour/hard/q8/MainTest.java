package pre_defined_classes.programs_with_changing_behaviour.hard.q8;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The first die rolled is a "),
                new RandomInteger(1, 7, "firstDie"),
                new StringLiteral("\\."),
                new NewLine(),
                new StringLiteral("The second die rolled is a "),
                new RandomInteger(1, 7, "secondDie"),
                new StringLiteral("\\."),
                new NewLine(),
                new StringLiteral("Players bordering "),
                new IntegerLiteral("sumOfDice"),
                new StringLiteral(" may collect resources this turn\\.")
        };
    }

    public void runMain() {
        SettlersOfCatan.main(new String[0]);
    }

    @RepeatedTest(10)
    void calculatesSumOfDiceCorrectly() {
        int diceSum = Integer.parseInt(getItemByName("firstDie")) + Integer.parseInt(getItemByName("secondDie"));
        assertEquals(diceSum, Integer.parseInt(getItemByName("sumOfDice")));
    }
}
