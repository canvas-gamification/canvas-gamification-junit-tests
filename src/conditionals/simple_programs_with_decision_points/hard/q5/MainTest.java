package conditionals.simple_programs_with_decision_points.hard.q5;

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
        return Stream.of(Arguments.of("a", "Vowel"), Arguments.of("e", "Vowel"), Arguments.of("i", "Vowel"), Arguments.of("o", "Vowel"), Arguments.of("u", "Vowel"), Arguments.of("k", "Not a vowel"), Arguments.of("b", "Not a vowel"), Arguments.of("x", "Not a vowel"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInputLate(String letter, String message) {
        runWithInput(letter);
        String output = getOutput();
        assertTrue(output.contains(message), "Your program does not correctly identify if " + letter + " is a vowel or consonant.");
    }

    @Test
    void doubleMessageTest() {
        runWithInput("a");
        String output = getOutput();
        assertTrue(output.contains("Vowel") ^ output.contains("Not a vowel"), "Your program prints both possible responses to the input.");
    }
}
