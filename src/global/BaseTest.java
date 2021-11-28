package global;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    public void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    public String getOutput() {
        return testOut.toString();
    }

    public String processRegexForPrintlnOutput(String regexPattern) {
        return regexPattern + "\\R";
    }

    public Matcher getMatches(String outputString, String patternString) {
        return Pattern.compile(patternString).matcher(outputString);
    }

    public void checkOutputFollowsPattern(String outputString, String patternString) {
        Matcher matcher = getMatches(outputString, patternString);
        assertTrue(matcher.find(), "Your code's output did not follow the correct structure/syntax.");
        // This ensures that their output only contains 1 instance of the matched regex string
        assertFalse(matcher.find());
    }

    public void testRandomNumberRange(int min, int max, int... randomNumbers) {
        for (int randomNumber : randomNumbers) {
            assertTrue(randomNumber >= min && randomNumber < max, "One or more of your randomly generated numbers fall outside of the required range.");
        }
    }

    public void testRandomNumberRange(double min, double max, double... randomNumbers) {
        for (double randomNumber : randomNumbers) {
            assertTrue(randomNumber >= min && randomNumber < max, "One or more of your randomly generated numbers fall outside of the required range.");
        }
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
}
