package conditionals.simple_programs_with_decision_points.hard.q5;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Parsons with distractors

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "22 31";

        return new Clause[]{
                new StringLiteral("Enter a character: "),
                new NewLine(),
                new Optional(new StringLiteral("Vowel")),
                new Optional(new StringLiteral("Not a vowel"))
        };
    }

    public void runMain() {
        CharaComb.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("a", 31), Arguments.of(22, 24));
    }
//test that both outputs aren't occuring
    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInputLate(int hours, int minutes) {
        runWithInput((hours + "") + " " + (minutes + ""));
        String output = getOutput();
        assertTrue(output.contains("Please go to sleep."), "Your program tells the user to stay up when they should be going to sleep.");
    }

}
