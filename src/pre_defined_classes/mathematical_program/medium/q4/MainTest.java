package pre_defined_classes.mathematical_program.medium.q4;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Our team scored "),
                new IntegerLiteral( "totalPoints"),
                new StringLiteral(" points this season!"),
                new NewLine(),
                new StringLiteral("The highest score was "),
                new IntegerLiteral("highScore"),
                new StringLiteral(" points."),
                new NewLine(),
                new StringLiteral("The lowest score was "),
                new IntegerLiteral("lowScore"),
                new StringLiteral(" points."),
        };
    }

    public void runMain() {
        BasketballGames.main(new String[0]);
    }

    @Test
    public void gameStatisticsOutput(){
        assertEquals(127, Integer.parseInt(getItemByName("totalPoints")),  "Calculated number of points is incorrect.");
        assertEquals(59, Integer.parseInt(getItemByName("highScore")), "Calculated high score is incorrect.");
        assertEquals(32, Integer.parseInt(getItemByName("lowScore")), "Calculated lowest score is incorrect.");
    }
}
