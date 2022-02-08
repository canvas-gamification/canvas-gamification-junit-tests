package temp;

import global.BaseRandomTest;
import global.variables.RandomDouble;
import global.variables.RandomInteger;
import global.variables.Clause;
import global.variables.StringLiteral;
import global.variables.NewLine;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static global.utils.RegexUtil.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuestionExample extends BaseRandomTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The prediction by Simon was: "),
                new RandomInteger(0, 100),
                new StringLiteral(", and the number of fingers you held up was: "),
                new RandomDouble(6.5, 10.5),
                new Optional(new StringLiteral(". They are the same!")),
                new NewLine(),
                new RandomDouble(6.5, 10.5)
        };
    }

    public void runMain() {
        ProphetRobot.main(new String[]{});
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
