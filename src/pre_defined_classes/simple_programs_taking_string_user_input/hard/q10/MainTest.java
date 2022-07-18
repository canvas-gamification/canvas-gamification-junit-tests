package pre_defined_classes.simple_programs_taking_string_user_input.hard.q10;

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
        TestOption.defaultInput = "1234abc ";
        return new Clause[]{
                new StringLiteral("Please enter a password\\: "),
                new NewLine(),
                new StringLiteral("Is the password too weak\\? "),
                new PlaceHolder()
        };
    }

    public void runMain(){PasswordWeakness.main(new String[0]);}

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("1234abc", "true"), Arguments.of("abc_password", "true"),
                Arguments.of("abc_Password", "true"), Arguments.of("ABCDE", "false")
                );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void identifiesPasswordWeaknessCorrectly(String passward, String bln) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not correctly print if the password entered is weak.";
        runWithInput(passward, new Clause[]{
                new StringLiteral(bln)
        });
    }
}
