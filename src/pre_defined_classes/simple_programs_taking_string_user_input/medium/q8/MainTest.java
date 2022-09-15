package pre_defined_classes.simple_programs_taking_string_user_input.medium.q8;

import global.BaseRandomTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.RandomChar;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Jae ";
        return new Clause[]{
                new StringLiteral("Please enter your username\\:"),
                new NewLine(),
                new StringLiteral("That name is taken\\. Try using this instead\\: "),
                new PlaceHolder(),
                new RandomChar('A', 'Z', "ranChar1", true),
                new RandomChar('A', 'Z', "ranChar2", true),
                new RandomChar('A', 'Z', "ranChar3",true)
        };
    }

    public void runMain() {
        UserName.main(new String[0]);
    }

    public static Stream<String> inputProvider() {
        return Stream.of("Jae", "James", "Robert", "Jennifer", "Mary", " ");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsSuggestedUserNameCorrectly(String input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not correctly print the suggested username.";
        runWithInput(input, new Clause[]{
                new StringLiteral(input, "orignalUserName"),
        });
    }
}
