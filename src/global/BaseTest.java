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
import static global.tools.Logger.parseTestInformation;
import static global.tools.TestSentenceUtil.*;
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
            BaseTest.injectedClauses = injectedClauses;
        }
    }

    public void setMultipleInjectedClauses(Clause[][] multipleInjectedClauses) {
        if (multipleInjectedClauses != null) {
            if (multipleInjectedClauses.length != placeHolderCount(testSentence())) {
                // TODO: check if failing here stops errors from invalid TestOptions from being a problem
                _fail("There is an issue with the test definition. Please contact an administrator.",
                        "The number of injected clause arrays is not equal to the number of placeholders in the test sentence");
            }
            BaseTest.injectedClauses = flattenMultipleInjections(multipleInjectedClauses);
        }
    }

    public Clause[] getInjectedClauses() {
        return BaseTest.injectedClauses;
    }

    // Utilities
    public void refreshOutputStream() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

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
            refreshOutputStream();
            executeMain(TestOption.defaultInput);
            outputFollowsCorrectStructure();
        } else {
            // TODO: better message
            _fail("Internal Error.", "Tried to run input without default input.");
        }
    }

    public void runWithInput(String input) {
        refreshOutputStream();
        executeMain(input);
        outputFollowsCorrectStructure();
    }

    public void runWithInput(String input, Clause[] injectedClauses) throws InvalidClauseException {
        // run with input when you have clauses to inject too
        refreshOutputStream();
        setInjectedClauses(injectedClauses);
        setRegexSentence(injectClauses(testSentence(), getInjectedClauses()));
        executeMain(input);
        outputFollowsCorrectStructure();
    }

    public void runWithInput(String input, Clause[][] multipleInjectedClauses) throws InvalidClauseException {
        // run with input when you have clauses to inject too
        refreshOutputStream();
        setMultipleInjectedClauses(multipleInjectedClauses);
        Clause[] modifiedTestSentence = expandTestSentence(testSentence(), multipleInjectedClauses);
        setRegexSentence(injectClauses(modifiedTestSentence, getInjectedClauses()));
        executeMain(input);
        outputFollowsCorrectStructure();
    }

    // Default Tests and Setup
    @BeforeAll
    public static void setUpLogger() {
        Logger.setCurrentSystemOut();
    }

    @BeforeEach
    public void setUp() throws InvalidClauseException, InvalidTestOptionException {
        setRegexSentence(testSentence());
        TestOption.validate();  // check that test options were set with valid options
        TestOption.reset();
        refreshOutputStream();

        if (TestOption.isInputTest) {
            runWithInput();
        } else {
            executeMain();
        }
    }

    @Test
    @Order(1)
    public void outputFollowsCorrectStructure() {
        String output = getOutput();
        Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(getRegexSentence())));
        String incorrectOutputMessage = TestOption.incorrectStructureErrorMessage;
       _assertTrue(matcher.find(), incorrectOutputMessage, parseTestInformation(output, getRegexSentence(), incorrectOutputMessage));
        //Ensures that the output matches the pattern exactly
        assertEquals(output.substring(matcher.start(), matcher.end()), output, incorrectOutputMessage);

        // check all clauses valid
        int matchGroupNum = 1;  // match group numbers are 1-indexed
        for (Clause clause : getRegexSentence()) {
            // TODO: student-facing message can include details + feedback should be dynamic to the clause's error
            _assertTrue(clause.validate(matcher.group(matchGroupNum)), incorrectOutputMessage, "Invalid Clause output at index " + matchGroupNum + " :" + clause.getInvalidMessage());
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
