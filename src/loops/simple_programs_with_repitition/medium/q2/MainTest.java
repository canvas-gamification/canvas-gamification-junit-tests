package loops.simple_programs_with_repitition.medium.q2;

import global.variables.*;
import global.variables.clauses.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10";

        return new Clause[] {
            new StringLiteral("Enter a number for the upper bound of the series: "),
            new NewLine(),
            new StringLiteral("The sum of the series is "),
            new IntegerLiteral("numberOutput")
        };
    }

    public void runMain() {
        AlternateIt.main(new String[0]);
    }

    public int seriesSum(int n) {
        int sum  = 0; 
        for(int i = 0; i < n; i++) 
           sum += Math.pow( -1, i ) * ( i + 1 );
        return(sum);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(0), Arguments.of(15), Arguments.of(456), Arguments.of(45646)); // Doesn't work with empty string
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(int input) throws InvalidClauseException {
        runWithInput("" + input);
        assertEquals(Integer.parseInt(getItemByName("numberOutput")), seriesSum(input), "Calculated value of output is incorrect");
    }
}