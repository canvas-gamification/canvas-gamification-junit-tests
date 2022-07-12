package pre_defined_classes.programs_with_changing_behaviour.hard.q7;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Your chance of winning is: "),
                new RandomInteger(10000, 999999+1, "chanceOfWinning")
        };
    }

    public void runMain() {
        LotteryChance.main(new String[0]);
    }
}