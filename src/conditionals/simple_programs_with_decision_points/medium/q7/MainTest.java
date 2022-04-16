package conditionals.simple_programs_with_decision_points.medium.q7;

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

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "0";
        return new Clause[]{
                new StringLiteral("What is your HP right now\\?"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        HProblem.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(100.0, "Remaining HP\\: 100\\.0 \\/ 100"), Arguments.of(0, "Not Alive"),
                Arguments.of(69.42, "Remaining HP\\: 69\\.42 \\/ 100"), Arguments.of(-5.0, "Not Alive"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctHPMessage(double hpInput, String output) throws InvalidClauseException {
        String errorMessage = "Ensure that if HP is less than or equal to zero the message \"Not Alive\" is printed";
        if(hpInput > 0)
            errorMessage = "Ensure that the correct remaining HP is printed";
        TestOption.incorrectStructureErrorMessage =  errorMessage;
        runWithInput(hpInput + "", new Clause[]{
                new StringLiteral(output)
        });
    }

}
