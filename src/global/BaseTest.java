package global;

import global.exceptions.InvalidClauseException;
import global.exceptions.InvalidTestOptionException;
import global.tools.Logger;
import global.tools.TestOption;
import global.variables.Clause;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

import static global.tools.CustomAssertions._assertTrue;
import static global.tools.CustomAssertions._fail;
import static global.tools.TestSentenceUtil.injectClauses;
import static global.tools.TestSentenceUtil.placeHolderCount;
import static global.utils.RegexUtil.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class BaseTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private String currentOutput = null;
    private ByteArrayOutputStream testOut;
    private static Clause[] regexSentence;
    private static Clause[] injectedClauses;

    // Test Developer defined
    public abstract Clause[] testSentence();

    public abstract void runMain();

    // Setters and Getters
    public void setRegexSentence(Clause[] regexSentence) throws InvalidClauseException {
        //By using a set we can ensure that there are no duplicates in the regexSentence
        Set<String> namesSet = new HashSet<>();
        for (Clause clause : regexSentence) {
            if (clause.getName() != null) {
                if (namesSet.contains(clause.getName())) {
                    _fail("There is an issue with the test definition. Please contact an administrator.",
                            "The name " + clause.getName() + " is already in use. make sure all names are unique");
                }
                namesSet.add(clause.getName());
            }
        }

        //validate all parameters used for the clauses
        for (int i = 0; i < regexSentence.length; i++) {
            Clause clause = regexSentence[i];
            try {
                clause.validateParams();
            } catch (InvalidClauseException e) {
                throw new InvalidClauseException("The parameter(s) for the clause at index " + (i + 1) + " are invalid. " + e.getMessage());
            }
        }

        BaseTest.regexSentence = regexSentence;
    }

    public Clause[] getRegexSentence() {
        return BaseTest.regexSentence;
    }

    public void setInjectedClauses(Clause[] injectedClauses) {
        if (injectedClauses != null) {
            if (injectedClauses.length != placeHolderCount(testSentence())) {
                // TODO: check if failing here stops errors from invalid TestOptions from being a problem
                _fail("There is an issue with the test definition. Please contact an administrator.",
                        "The number of injected clauses is not equal to the number of placeholders in the test sentence");
            }
        }
        BaseTest.injectedClauses = injectedClauses;
    }

    public Clause[] getInjectedClauses() {
        return BaseTest.injectedClauses;
    }

    public boolean hasInjectedClauses() {
        return BaseTest.injectedClauses != null;
    }

    // Utilities
    public void executeMain() {
        currentOutput = null;
        runMain();
    }

    public void executeMain(String input) {
        provideInput(input);
        currentOutput = null;
        runMain();
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

    public String getItemAtIndex(int index) {
        // TODO: this needs to be memoized
        Matcher matcher = getMatches(getOutput(), processRegexForPrintlnOutput(combineRegex(getRegexSentence())));
        try {
            if (matcher.find()) return matcher.group(index);
            else fail("Your code's output did not follow the correct structure/syntax");
        } catch (IndexOutOfBoundsException e) {
            fail("The specified group (" + index + ") doesn't exist");
        }
        return "";  // TODO: logically how does this behave?
    }

    public String getItemByName(String name) {
        Clause[] regSen = getRegexSentence();
        for (int i = 0; i < regSen.length; i++) {
            if (regSen[i].getName() != null && regSen[i].getName().equals(name))
                return getItemAtIndex(i + 1);
        }
        fail("The specified group ('" + name + "') doesn't exist");
        return ""; // TODO: logically how does this behave?
    }

    public void runWithInput() {
        // Run with default input if specified, fail if not specified
        if (TestOption.isInputTest && TestOption.defaultInput != null) {
            executeMain(TestOption.defaultInput);
        } else {
            // TODO: better message
            _fail("Internal Error.", "Tried to run input without default input.");
        }
    }

    public void runWithInput(String input) {
        executeMain(input);
    }

    public void runWithInput(String input, Clause[] injectedClauses) throws InvalidClauseException {
        // run with input when you have clauses to inject too
        setInjectedClauses(injectedClauses);
        setRegexSentence(injectClauses(testSentence(), getInjectedClauses()));
        executeMain(input);
    }

    // Default Tests and Setup
    @BeforeAll
    public static void setUpLogger() {
        Logger.setCurrentSystemOut();
    }

    @BeforeEach
    public void setUp() throws InvalidClauseException, InvalidTestOptionException {
        // TODO: before each test, we always set the regex sentence again. If injected clauses are provided, inject them
        setRegexSentence(testSentence());  // TODO: think harder
        TestOption.validate();  // check that test options were set with valid options
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        if (TestOption.isInputTest) {
            runWithInput();
        } else {
            executeMain();
        }
    }

    @Test
    @Order(1)
    public void checkOutputFollowsPattern() {
        String output = getOutput();
        Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(getRegexSentence())));
        assertTrue(matcher.find(), "Your code's output did not follow the correct structure/syntax.");
        //Ensures that the output matches the pattern exactly
        assertEquals(output.substring(matcher.start(), matcher.end()), output, "Your code's output did not follow the correct structure/syntax.");
        // This ensures that their output only contains 1 instance of the matched regex string  // TODO: still needed?
        assertFalse(matcher.find());
    }

    @Test
    public void allClausesValid() {
        String output = getOutput();
        Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(getRegexSentence())));
        assertTrue(matcher.find(), "Your code's output did not follow the correct structure/syntax.");

        int matchGroupNum = 1;  // match group numbers are 1-indexed
        for (Clause clause : getRegexSentence()) {
            // TODO: devMessage could be improved
            _assertTrue(clause.validate(matcher.group(matchGroupNum)), clause.getInvalidMessage(), "Invalid Clause output at index " + matchGroupNum);
            matchGroupNum++;
        }
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        currentOutput = null;
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
}
