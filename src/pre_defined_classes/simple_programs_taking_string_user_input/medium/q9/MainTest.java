package pre_defined_classes.simple_programs_taking_string_user_input.medium.q9;

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
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "BBC news is reporting the weather.";
        return new Clause[]{
                new StringLiteral("Enter your comment:"),
                new NewLine(),
                new StringLiteral("Your lowercase comment is: "),
                new PlaceHolder()
        };
    }

    public void runMain() { redditComment.main(new String[0]);}

    public static Stream<String> inputProvider() {
        return Stream.of("BBC news is reporting the weather.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsCommentsInLowerCase(String input) throws InvalidClauseException {
        String lowered = input.toLowerCase();
        TestOption.incorrectStructureErrorMessage = " ";
        runWithInput(input, new Clause[]{
                new StringLiteral(lowered, "pluralS")
        });
    }
}
