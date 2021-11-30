package pre_defined_classes.programs_with_changing_behaviour.medium;

import global.BaseRandomTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import temp.ProphetRobot;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class Question1 extends BaseRandomTest {
    static String patternRegex = "(The prediction by Simon was:) ([0-9]{1,2})(, and the number of fingers you held up was:) ([0-9]{1,2})";
    static Set<Integer> outputValues1 = new HashSet<>();
    static Set<Integer> outputValues2 = new HashSet<>();

    @Test
    public void Check_output_contains_correct_string() {
        ProphetRobot.main(new String[0]);
        checkOutputFollowsPattern(getOutput(), processRegexForPrintlnOutput(patternRegex));
    }

    @RepeatedTest(500)
    public void Check_random_numbers_in_range(RepetitionInfo repetitionInfo) {
        ProphetRobot.main(new String[0]);
        Matcher matcher = getMatches(getOutput(), patternRegex);

        if (matcher.find()) {
            int num1 = Integer.parseInt(matcher.group(2));
            int num2 = Integer.parseInt(matcher.group(4));
            outputValues1.add(num1);
            outputValues2.add(num2);
            testRandomNumberRange(0, 11, num1, num2);
        }

        if (repetitionInfo.getCurrentRepetition() == repetitionInfo.getTotalRepetitions()) {
            assertNotEquals(1, outputValues1.size(), "You do not seem to be properly generating random values.");
            assertNotEquals(1, outputValues2.size(), "You do not seem to be properly generating random values.");
        }
    }
}