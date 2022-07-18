package pre_defined_classes.simple_programs_taking_string_user_input.hard.q9;

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
        TestOption.defaultInput = "silvester ";
        return new Clause[]{
                new StringLiteral("Please enter your last name\\:"),
                new NewLine(),
                new StringLiteral("Is the person from Portugal\\? "),
                new PlaceHolder(),
                new NewLine(),
                new StringLiteral("Does the person\\'s name contain his\\/her parent\\'s name\\? "),
                new PlaceHolder()
        };
    }

    public void runMain(){Origin.main(new String[0]);}

    public static Stream<String> inputProvider() {
        return Stream.of("silvester", "jackson", "smith", "silson");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void determinesOriginByLastName (String name) throws InvalidClauseException {
        boolean isPortugese = name.startsWith( "sil" );
        boolean isSon = name.endsWith( "son" );
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print if the user is " +
                "originated from Portugal or has parent's name in the user's name.";
        runWithInput(name, new Clause[]{
                new StringLiteral(String.valueOf(isPortugese)),
                new StringLiteral(String.valueOf(isSon))
        });
    }
}
