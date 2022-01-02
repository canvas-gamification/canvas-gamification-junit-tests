package global;

import static global.utils.RegexUtil.*;

import global.variables.Regexable;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class BaseTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private String currentOutput = null;
    private Regexable[] regexSentence;

    private ByteArrayOutputStream testOut;

    // Setters and Getters
    public abstract Regexable[] getExpectedOutput();

    public void setRegexSentence(Regexable[] regexSentence) {
        this.regexSentence = regexSentence;
    }

    public Regexable[] getRegexSentence() {
        return this.regexSentence;
    }

    public String getItemAtIndex(int index) {
        Matcher matcher = getMatches(getOutput(), processRegexForPrintlnOutput(combineRegex(getRegexSentence())));
        try {
            if (matcher.find()) return matcher.group(index);
            else fail("Your code's output did not follow the correct structure/syntax");
        } catch (ArrayIndexOutOfBoundsException e) {
            fail("The specified group doesn't exist");
        }
        return "";  // TODO: logically how does this behave?
    }

    // Utilities
    // TODO: if possible, make this getTestedClass() and then use reflections to call .main() inside executeMain()
    public abstract void runMain();

    public void executeMain() {
        currentOutput = null;
        runMain();
        // TODO: reflections and such
    }

    public void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    public String getOutput() {
        if (currentOutput != null) {
            return currentOutput;
        }
        currentOutput = testOut.toString();
        return currentOutput;
    }

    // Default Tests and Setup
    @BeforeEach
    public void setUp() {
        setRegexSentence(getExpectedOutput());
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        executeMain();
    }

    @Test
    public void checkOutputFollowsPattern() {
        String output = getOutput();
        // TODO: not always println though (in general how do we handle multi line outputs?)
        Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(getRegexSentence())));
        assertTrue(matcher.find(), "Your code's output did not follow the correct structure/syntax.");
        // This ensures that their output only contains 1 instance of the matched regex string
        assertFalse(matcher.find());
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        currentOutput = null;
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
}
