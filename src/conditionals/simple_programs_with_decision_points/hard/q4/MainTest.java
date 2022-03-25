package conditionals.simple_programs_with_decision_points.hard.q4;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "true";

        return new Clause[]{
                new StringLiteral("Is the door open or closed right now\\? \\(Enter true for open and false for closed\\)"),
                new NewLine(),
                new Optional(new StringLiteral("I will close the door")),
                new Optional(new StringLiteral("Time to open the door"))
        };
    }

    public void runMain() {
        DoorBoy.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("true", "I will close the door"), Arguments.of("false", "Time to open the door"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String open, String message) {
        runWithInput(open);
        String output = getOutput();
        assertTrue(output.contains(message), "Your program does not tell the user the correct action to take with the door.");
    }

    @Test
    void doubleMessageTest(){
        runWithInput("true");
        String output = getOutput();
        assertTrue(output.contains("I will close the door") ^ output.contains("Time to open the door"), "Your program prints both possible responses to the input.");
    }
}
