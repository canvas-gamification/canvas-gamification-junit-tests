package pre_defined_classes.simple_programs_taking_string_user_input.medium.q4;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Bob Ross";
        return new Clause[]{
                new StringLiteral("What is your full name\\? "),
                new NewLine(),
                new StringLiteral("Your first name has "),
                new PlaceHolder(),
                new StringLiteral(" characters and your last name has "),
                new PlaceHolder(),
                new StringLiteral(" characters. ")
        };
    }

    public void runMain() {
        CompareNames.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("Bob Ross", 3, 4), Arguments.of("vSauce Micheal", 6, 7), Arguments.of("John Snow", 4, 4));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculatesNameLengthsCorrectly(String name, int firstNameLength, int surnameLength) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly calculate and print the length of the two names.";
        runWithInput(name, new Clause[]{
                new IntegerLiteral(firstNameLength, "firstNameLength"),
                new IntegerLiteral(surnameLength, "surnameLength")
        });
    }
}
