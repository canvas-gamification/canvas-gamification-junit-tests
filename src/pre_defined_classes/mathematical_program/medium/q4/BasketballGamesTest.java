package pre_defined_classes.mathematical_program.medium.q4;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class BasketballGamesTest extends BaseRandomTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Our team scored "),
                new IntegerLiteral(127),
                new StringLiteral(" points in the season!"),
                new NewLine(),
                new StringLiteral("The highest score was "),
                new IntegerLiteral(59),
                new StringLiteral(" points."),
                new NewLine(),
                new StringLiteral("The lowest score was "),
                new IntegerLiteral(32),
                new StringLiteral(" points."),
        };
    }

    public void runMain() {
        BasketballGames.main(new String[0]);
    }
}
