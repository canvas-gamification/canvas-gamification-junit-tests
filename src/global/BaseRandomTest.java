package global;

import global.variables.Clause;
import global.variables.RandomClause;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.regex.Matcher;

import static global.utils.RegexUtil.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class BaseRandomTest extends BaseTest {
    static boolean alreadyFailed = false;

    // TODO: choose number
    @RepeatedTest(500)
    public void testRandomNumbers(RepetitionInfo repetitionInfo) {
        if (alreadyFailed) fail();  // TODO: No message (?)

        String output = getOutput();
        Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(getRegexSentence())));
        if (matcher.find()) {
            for (int i = 0; i < getRegexSentence().length; i++) {
                Clause regexClause = getRegexSentence()[i];
                if (!(regexClause instanceof RandomClause)) continue;
                RandomClause<?> randomVariable = (RandomClause<?>) regexClause;

                int matchGroupNum = i + 1;
                String groupValue = matcher.group(matchGroupNum);
                randomVariable.trackValue(matchGroupNum, groupValue);
            }
        } else {
            alreadyFailed = true;
            fail("Incorrect format.");
        }

        if (repetitionInfo.getCurrentRepetition() == repetitionInfo.getTotalRepetitions()) {
            for (int i = 0; i < getRegexSentence().length; i++) {
                Clause regexClause = getRegexSentence()[i];
                if (!(regexClause instanceof RandomClause)) continue;
                RandomClause<?> randomVariable = (RandomClause<?>) regexClause;

                int mapKey = i + 1;
                // TODO: more info about which value, the way it's bad (out of bounds, within bounds, obviously hardcoded, etc) (?)
                assertTrue(randomVariable.validateRandom(mapKey), "You do not seem to be properly generating random values.");
            }
        }
    }
}
