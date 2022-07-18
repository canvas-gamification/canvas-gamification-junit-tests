package pre_defined_classes.simple_programs_taking_string_user_input.hard.q7;

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
        TestOption.defaultInput = "ka ";
        return new Clause[]{
                new StringLiteral("Enter a syllable\\: "),
                new NewLine(),
                new StringLiteral("Does the input syllable have CV structure\\? "),
                new PlaceHolder()
        };
    }

    public void runMain(){Syllable.main(new String[0]);}

    public static Stream<String> CVStructure() {
        return Stream.of("da", "ke", "hi","no", "tu");
    }

    public static Stream<String> nonCVStructure() {
        return Stream.of("bb", "by","aa", "12", "ab");
    }

    @ParameterizedTest
    @MethodSource("CVStructure")
    public void identifiesCVStructure(String input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not print the output correctly when the input is a CV structure.";
        runWithInput(input, new Clause[]{
                new StringLiteral("true")
        });
    }

    @ParameterizedTest
    @MethodSource("nonCVStructure")
    public void identifiesNonCVStructures(String input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not print the output correctly when the input is not a CV structure.";
        runWithInput(input, new Clause[]{
                new StringLiteral("false")
        });
    }
}
