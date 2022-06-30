package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q8;

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

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Sample Output:
    How many classes were there?
    24
    How many classes did you attend?
    19
    You've attended 79% of the classes. You need 75% to pass.
 */

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "24 24";
        return new Clause[]{
                new StringLiteral("How many classes were there?"),
                new NewLine(),
                new StringLiteral("How many classes did you attend?"),
                new NewLine(),
                new StringLiteral("You've attended "),
                new IntegerLiteral("percentage"),
                new StringLiteral( "% of the classes. You need 75% to pass."),
        };
    }
    public void runMain(){Attendance.main(new String[0]);}

    public static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(24, 24), Arguments.of(24, 19), Arguments.of(24, 6));
    }

    /*
Sample Output:
    How many classes were there?
    24
    How many classes did you attend?
    19
    You've attended 79% of the classes. You need 75% to pass.
 */
    @ParameterizedTest
    @MethodSource("inputProvider")
    public void nam(int numClasses, int attendedClasses) throws InvalidClauseException {

        int percentage = attendedClasses * 100 / numClasses;

        runWithInput(numClasses + " " + attendedClasses);
        assertEquals(Integer.parseInt(getItemByName("percentage")),percentage);

    }
}
