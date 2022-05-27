package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";
        return new Clause[]{
                new StringLiteral("Enter the length of the side of a square: "),
                new NewLine(),
                new StringLiteral("The area is: "),
                new IntegerLiteral("area"),
                new NewLine(),
                new StringLiteral("The perimeter is: "),
                new IntegerLiteral("perimeter")
        };
    }

    public void runMain() {
        SquareSpace.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(5, 25, 20), Arguments.of(200, 40000, 800), Arguments.of(9, 81, 36), Arguments.of(15, 225, 60));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculatesAreaCorrectly(int length, int area, int perimeter) throws InvalidClauseException {
        runWithInput(System.lineSeparator() + length);
        assertEquals(Integer.parseInt(getItemByName("area")), area, "Your program does not correctly calculate the area of a square.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculatesPerimeterCorrectly(int length, int area, int perimeter) throws InvalidClauseException {
        runWithInput(System.lineSeparator() + length);
        assertEquals(Integer.parseInt(getItemByName("perimeter")), perimeter, "Your program does not correctly calculate the area of a square.");
    }
}
