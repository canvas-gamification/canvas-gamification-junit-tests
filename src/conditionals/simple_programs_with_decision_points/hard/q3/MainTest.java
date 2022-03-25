package conditionals.simple_programs_with_decision_points.hard.q3;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Parsons with distractors

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "22 31";

        return new Clause[]{
                new StringLiteral("Current Time Hours \\(in a 24h clock\\): "),
                new NewLine(),
                new StringLiteral("Current Time Minutes:  "),
                new NewLine(),
                new Optional(new StringLiteral("Please go to sleep.")),
                new Optional(new StringLiteral("The night is still young!"))
        };
    }

    public void runMain() {
        SleepyTime.main(new String[0]);
    }

    static Stream<Arguments> inputProviderLate() {
        return Stream.of(Arguments.of(22, 31), Arguments.of(22, 24));
    }

    static Stream<Arguments> inputProviderEarly() {
        return Stream.of(Arguments.of(20, 56), Arguments.of(18, 1));
    }

    @ParameterizedTest
    @MethodSource("inputProviderLate")
    void testWithInputLate(int hours, int minutes) {
        runWithInput((hours + "") + " " + (minutes + ""));
        String output = getOutput();
        assertTrue(output.contains("Please go to sleep."), "Your program tells the user to stay up when they should be going to sleep.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderEarly")
    void testWithInputEarly(int hours, int minutes) {
        runWithInput((hours + "") + " " + (minutes + ""));
        String output = getOutput();
        assertTrue(output.contains("The night is still young!"), "Your program tells the user to go to sleep when they should be staying up.");
    }

    @Test
    void doubleMessageTest(){
        runWithInput("15 21");
        String output = getOutput();
        assertTrue(output.contains("The night is still young!") ^ output.contains("Please go to sleep."), "Your program prints both possible responses to the input.");
    }
}
