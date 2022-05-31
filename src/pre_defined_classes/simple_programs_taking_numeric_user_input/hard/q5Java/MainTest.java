package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q5Java;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "85.4";
        return new Clause[]{
                new StringLiteral("Enter your grade in percentage: "),
                new Optional(new NewLine()),
                new PlaceHolder(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        LetterCalculator.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(85.4, 3.2700000000000005), Arguments.of(67.5, 2.375), Arguments.of(0, -1), Arguments.of(74.268, 2.7134),
                Arguments.of(100, 4.0), Arguments.of(42.33, 1.1164999999999998));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculatesGPACorrectly(double grade, double gpa) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not follow the sample output.";
        runWithInput(String.valueOf(grade), new Clause[]{
                new StringLiteral("Your GPA is: "),
                new DoubleLiteral("gpa")
        });
        assertEquals(Double.parseDouble(getItemByName("gpa")), gpa, 0.001, "Your program does not calculate GPA correctly.");
    }
}
