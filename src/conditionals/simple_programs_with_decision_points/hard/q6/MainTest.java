package conditionals.simple_programs_with_decision_points.hard.q6;

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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Parsons with distractors

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "150";

        return new Clause[]{
                new StringLiteral("Enter your current temperature \\( in fahrenheit \\): "),
                new NewLine(),
                new Optional(new StringLiteral("You have a fever. Stay at home and rest.")),
                new Optional(new StringLiteral("You don't have a fever. Have fun out there!"))
        };
    }

    public void runMain() {
        TempCalc.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("100", "You have a fever. Stay at home and rest."), Arguments.of("90", "You don't have a fever. Have fun out there!"), Arguments.of("115", "You have a fever. Stay at home and rest."));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInputLate(String temperature, String message) {
        runWithInput(temperature);
        String output = getOutput();
        assertTrue(output.contains(message), "Your program does not correctly identify when a person does or does not have a fever. Check your if statement.");
    }

    @Test
    void doubleMessageTest() {
        runWithInput("40");
        String output = getOutput();
        assertTrue(output.contains("You have a fever. Stay at home and rest.") ^ output.contains("You don't have a fever. Have fun out there!"), "Your program prints both possible responses to the input.");
    }
}
