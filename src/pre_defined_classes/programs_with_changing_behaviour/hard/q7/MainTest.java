package pre_defined_classes.programs_with_changing_behaviour.hard.q7;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomDouble;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Your chance of winning is: "),
                new RandomDouble(0, 100+1, "chanceOfWinning")
        };
    }

    public void runMain() {
        LotteryChance.main(new String[0]);
    }
}