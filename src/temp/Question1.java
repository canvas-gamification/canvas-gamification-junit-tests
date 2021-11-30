package temp;

import global.BaseRandomTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;


public class Question1 extends BaseRandomTest {
    static String patternRegex = "A: ([0-9]+) B: ([0-9]+\\.[0-9]+) C: ([0-9]+)";

    @BeforeAll
    public static void initialize() {
        initializeRandomIntegers(1, 3);
        initializeRandomDoubles(2);
    }

    @Test
    public void Check_output_contains_correct_string() {
        ProphetRobotModified.main(new String[0]);
        checkOutputFollowsPattern(getOutput(), processRegexForPrintlnOutput(patternRegex));
    }

    @RepeatedTest(500)
    public void Check_random_numbers(RepetitionInfo repetitionInfo) {
        ProphetRobotModified.main(new String[0]);
        testRandomIntegersHelper(patternRegex, 0, 2, repetitionInfo, 1);
//        testRandomIntegersHelper(patternRegex, 0, 5, repetitionInfo, 2);
        testRandomDoublesHelper(patternRegex, 0, 10, repetitionInfo, 2);
        testRandomIntegersHelper(patternRegex, 0, 11, repetitionInfo, 3);
    }
}