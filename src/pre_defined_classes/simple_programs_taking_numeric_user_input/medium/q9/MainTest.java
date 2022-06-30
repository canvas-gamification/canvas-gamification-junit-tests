package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q9;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Sample output:
    What is the 3 digit plate number?
    678
    The reverse number is: 876
 */
public class MainTest extends BaseTest {
    //Parson
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "678";
        return new Clause[]{
                new StringLiteral( "What is the 3 digit plate number?" ),
                new NewLine(),
                new StringLiteral( "The reverse number is: "),
                new IntegerLiteral("reversePlate")
        };
    }

    public void runMain() {ReversePlate.main(new String[0]);}

    public static Stream<Integer> inputProvider2(){
        return Stream.of(678, 102, 345);
    }

    @ParameterizedTest
    @MethodSource("inputProvider2")
    public void nm(int plate) throws InvalidClauseException {

        int num1 = plate / 100;
        plate = plate % 100;
        int num2 = plate / 10;
        int num3 = plate % 10;
        int reversePlate = num3 * 100 + num2 * 10 + num1;

        runWithInput(plate + System.lineSeparator());
        assertEquals(Integer.parseInt(getItemByName("reversePlate")), reversePlate, "Incorrect reverse plate.");
    }

}
