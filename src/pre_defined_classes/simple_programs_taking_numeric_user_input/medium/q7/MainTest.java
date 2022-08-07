package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q7;

import global.BaseRandomTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "-5";
        return new Clause[]{
                new StringLiteral("Enter your score between \\-10 and 10 \\(both ends included\\)\\: "),
                new NewLine(),
                new StringLiteral("Your score modifier is: "),
                new RandomInteger(1, 11, "modifier"),
                new NewLine(),
                new StringLiteral("Your goal is "),
                new IntegerLiteral("score"),
                new StringLiteral(". Keep up the good work!")
        };
    }

    public void runMain() {
        AbsoluteNumber.main(new String[0]);
    }

    public static Stream<Integer> inputProvider() {
        return Stream.of(3, 0, -5, 10, -1);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsFinalScoreCorrectly(int input) throws InvalidClauseException {
        runWithInput(String.valueOf(input));
        int score = Math.abs(input) * Integer.parseInt(getItemByName("modifier"));
        assertEquals(score, Integer.parseInt(getItemByName("score")), "Your program does not correctly multiply the input score by a random score modifier.");
    }
}
