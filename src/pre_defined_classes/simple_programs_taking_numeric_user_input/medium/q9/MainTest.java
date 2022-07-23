package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q9;

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
    // Parsons
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "678";
        return new Clause[]{
                new StringLiteral( "What is the 3 digit plate number\\?" ),
                new NewLine(),
                new StringLiteral( "The reverse number is\\: "),
                new PlaceHolder()
        };
    }

    public void runMain() {ReversePlate.main(new String[0]);}

    public static Stream<Arguments> inputProvider2(){
        return Stream.of(Arguments.of(678, "876"), Arguments.of(102, "201"), Arguments.of(345, "543")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider2")
    public void reversesPlateCorrectly(int plate, String reversePlate) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the reversed plate correctly.";
        runWithInput(plate + " ", new Clause[]{
                new StringLiteral(reversePlate)
        });
    }
}
