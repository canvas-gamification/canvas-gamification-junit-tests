package pre_defined_classes.simple_programs_taking_string_user_input.hard.q8;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "The French Dip with mushrooms, a side of fries, and gravy please.";
        return new Clause[]{
                new StringLiteral("Please enter favourite country:"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {FlipChars.main(new String[0]);}

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("Canada", "aanadC"), Arguments.of("Hungary", "yungarH"),
                Arguments.of("netherlands", "setherlandn"),
                Arguments.of("ab", "ba"),Arguments.of("123", "321")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsFlippedCountryNameCorrectly(String originalName, String flippedName) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not correctly print the flipped country name.";
        runWithInput(originalName, new Clause[]{
                new StringLiteral(flippedName)
        });
    }
}
