package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q8;

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
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "24 24 ";
        return new Clause[]{
                new StringLiteral("How many classes were there\\?"),
                new NewLine(),
                new StringLiteral("How many classes did you attend\\?"),
                new NewLine(),
                new StringLiteral("You've attended "),
                new IntegerLiteral("percentage"),
                new StringLiteral( "\\% of the classes and you need 75\\% to write the final exam\\."),
        };
    }
    public void runMain(){Attendance.main(new String[0]);}

    public static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(24, 24, 100), Arguments.of(24, 19, 79), Arguments.of(6, 1, 16),
                Arguments.of(11, 0, 0), Arguments.of(6, 1, 16), Arguments.of(1, 6, 600),
                Arguments.of(-24, 24, -100), Arguments.of(24, -24, -100)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculateAttendanceCorrectly(int numClasses, int attendedClasses, int percentage) throws InvalidClauseException {
        runWithInput(numClasses + " " + attendedClasses + " ");
        assertEquals(Integer.parseInt(getItemByName("percentage")), percentage, "Your program does not correctly calculate attendance percentage.");
    }
}
