package pre_defined_classes.programs_with_changing_behaviour.hard.q7;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseRandomTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("You bought "),
                new IntegerLiteral(4, "tickets"),
                new StringLiteral(" tickets\\."),
                new NewLine(),
                new StringLiteral("The number of tickets in the lottery is: "),
                new RandomInteger(10000, 1000000, "totalTickets"),
                new StringLiteral("\\."),
                new NewLine(),
                new StringLiteral("Your chance of winning is: "),
                new DoubleLiteral("winChance"),
                new StringLiteral("%.")
        };
    }

    public void runMain() {
        LotteryChance.main(new String[0]);
    }

    @RepeatedTest(10)
    void calculatesWinChanceCorrectly() {
        double chance = 4.0 / Double.parseDouble(getItemByName("totalTickets")) * 100.00;
        assertEquals(chance, Double.parseDouble(getItemByName("winChance")), 0.0000000000001, "Your program does not correctly calculate the chances of you winning the lottery.");
    }
}
