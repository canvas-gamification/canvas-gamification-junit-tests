package global;

import global.exceptions.InvalidClauseException;
import global.exceptions.InvalidTestOptionException;
import global.tools.Logger;
import global.variables.Clause;
import global.variables.RandomClause;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.regex.Matcher;

import static global.tools.CustomAssertions._assertTrue;
import static global.tools.CustomAssertions._fail;
import static global.utils.RandomUtil.castRandomClause;
import static global.utils.RegexUtil.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class BaseRandomTest extends BaseTest {
    final static int NUM_RUNS = 500;  // TODO: this could be generated based on ranges
    final static String MESSAGE_INCORRECT_RANDOM = "You do not seem to be properly generating random values.";

    @Test
    @Order(1)
    public void randomNumbersAreCorrectlyGenerated() throws InvalidClauseException, InvalidTestOptionException {
        for (int repetitionCount = 1; repetitionCount <= NUM_RUNS; repetitionCount++) {
            setUp();
            String output = getOutput();
            Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(getRegexSentence())));
            if (!matcher.find()) {
                restoreSystemInputOutput();
                break;
            }

            storeRandomClauseValues(matcher);
            if (repetitionCount == NUM_RUNS) {
                checkRandomNumberDistributions();
                return;
            }
            restoreSystemInputOutput();
        }
        // Fail case
        _fail(MESSAGE_INCORRECT_RANDOM, "While checking for randomness, an output that didn't match the test sentence was encountered.");
    }

    public void storeRandomClauseValues(Matcher outputMatcher) {
        for (int i = 0; i < getRegexSentence().length; i++) {
            Clause regexClause = getRegexSentence()[i];
            RandomClause<?> randomVariable = castRandomClause(regexClause);
            if (randomVariable == null) continue;

            int matchGroupNum = i + 1;
            String groupValue = outputMatcher.group(matchGroupNum);
            randomVariable.trackValue(matchGroupNum, groupValue);
        }
    }

    public void checkRandomNumberDistributions() {
        for (int i = 0; i < getRegexSentence().length; i++) {
            Clause regexClause = getRegexSentence()[i];
            RandomClause<?> randomVariable = castRandomClause(regexClause);
            if (randomVariable == null) continue;

            int mapKey = i + 1;
            // TODO: the way it's bad (out of bounds, within bounds, obviously hardcoded, etc) (?)
            try {
                _assertTrue(randomVariable.validateRandom(mapKey), MESSAGE_INCORRECT_RANDOM,
                        "Invalid Random Values at " + mapKey);
            } catch (Error error) {
                Logger.logMessage(
                        String.join(" ",
                                "Randomness Error @",
                                randomVariable.getClass().getSimpleName(),
                                "(",
                                "" + mapKey,
                                ")"
                        )
                );
                Logger.logMessage(randomVariable.getValuesForMatchGroup(mapKey).toString());
                throw error;
            }
        }
    }
}
