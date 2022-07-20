package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q7;


/*
Sample output:
Enter your score:
-5
Your goal is 45. Keep up the good work!
 */

import global.BaseRandomTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "-5";
        return new Clause[]{
                new StringLiteral("Enter your score between \\-10 and 10 \\(both ends included\\)\\: "),
                new NewLine(),
                new StringLiteral("Your goal is "),
                new RandomInteger(0, 101),
                new StringLiteral(". Keep up the good work!")
        };
    }

    public void runMain(){ AbsoluteNumber.main(new String[0]); }

    public static Stream<Integer> inputProvider(){
        return Stream.of( 3 , 0 , -5);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctlyPrintsRandomAbsValue(int input) throws InvalidClauseException{
        runWithInput(input + " ");
    }
}
