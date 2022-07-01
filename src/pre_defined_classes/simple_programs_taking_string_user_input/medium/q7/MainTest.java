package pre_defined_classes.simple_programs_taking_string_user_input.medium.q7;

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
        TestOption.defaultInput = "https://www.canada.ca";
        return new Clause[]{
                new StringLiteral("Please enter a website URL:"),
                new NewLine(),
                new StringLiteral("Is this a Canadian website? "),
                new PlaceHolder(),
        };
    }

    public void runMain(){ UrlValidator.main(new String[0]);}

    public static Stream<String> canadianWebsite() {
        return Stream.of("https://www.canada.ca");
    }

    public static Stream<String> noneCanadianWebsite() {
        return Stream.of("https://www.gouvernement.fr");
    }

    @ParameterizedTest
    @MethodSource("canadianWebsite")
    public void printsTrue(String caUrl) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print true when a url ends with .ca";
        runWithInput(caUrl, new Clause[]{
                new StringLiteral("true"),
        });
    }

    @ParameterizedTest
    @MethodSource("noneCanadianWebsite")
    public void printsFalse(String notCaUrl) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print false when a url does not end with .ca";
        runWithInput(notCaUrl, new Clause[]{
                new StringLiteral("false"),
        });
    }
}
