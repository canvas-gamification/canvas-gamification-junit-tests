package temp;

import global.BaseRandomTest;
import global.variables.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static global.utils.RegexUtil.*;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionExample extends BaseRandomTest {
    //    System.out.println("The prediction by Simon was: " + prediction + ", num: " + num + " and the number of fingers you held up was: " + fingersHeldUp);
    public Clause[] getExpectedOutput() {
        return new Clause[]{
                new StringLiteral("The prediction by Simon was: "),
                new RandomInteger(0, 100),
                new StringLiteral(", num: "),
                new RandomDouble(12, 62),
                new StringLiteral(" and the number of fingers you held up was: "),
                new RandomChar('A', 'F'),
                new NewLine(),
                new RandomChar('A', 'F'),
                new Optional(new StringLiteral(". They are the same!"))
        };
    }

    public void runMain() {
        ProphetRobot.main(new String[0]);
    }

    @Test
    public void sampleTest() {
        String output = getOutput();
        System.err.println(output);
        System.err.println(processRegexForPrintlnOutput(combineRegex(getRegexSentence())));
        Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(getRegexSentence())));
        assertTrue(matcher.find(), "Your code's output did not follow the correct structure/syntax.");
        // This ensures that their output only contains 1 instance of the matched regex string
        assertFalse(matcher.find());
    }
}
