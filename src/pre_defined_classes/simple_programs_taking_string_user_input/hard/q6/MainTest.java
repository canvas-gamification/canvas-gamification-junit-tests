package pre_defined_classes.simple_programs_taking_string_user_input.hard.q6;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "example@ubc.ca";
        return new Clause[]{
                new StringLiteral("Please enter your email\\:"),
                new NewLine(),
                new StringLiteral("Is this a UBC email\\? "),
                new PlaceHolder()
        };
    }

    public void runMain(){CanValidator.main(new String[0]);}

    public static Stream<String> UBCEmail() {
        return Stream.of("example@ubc.ca");
    }

    public static Stream<String> nonUBCEmail() {
        return Stream.of("example2@gmail.com", "example3@ubc.com", "example3@gamil.ca",
                "notValidEmailFormat", System.lineSeparator()
        );
    }

    @ParameterizedTest
    @MethodSource("UBCEmail")
    public void identifiesUBCEmailCorrectly(String input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not print the correct output when the input is a UBC email.";
        runWithInput(input, new Clause[]{
                new StringLiteral("true")
        });
    }

    @ParameterizedTest
    @MethodSource("nonUBCEmail")
    public void identifiesNonUBCEmailCorrectly(String input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not print the output correctly when the input is not a UBC email.";
        runWithInput(input, new Clause[]{
                new StringLiteral("false")
        });
    }
}
