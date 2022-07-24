package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q10;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
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
        TestOption.defaultInput = "510 800 -110.0 ";
        return new Clause[]{
                new StringLiteral("How much do all the travellers weigh in pounds\\?"),
                new NewLine(),
                new StringLiteral("How much does the gas weigh for the return flight in pounds\\?"),
                new NewLine(),
                new StringLiteral("You can have "),
                new DoubleLiteral("luggage"),
                new StringLiteral(" pounds of luggage in total\\.")
        };
    }

    public void runMain(){ PiperSaratoga.main(new String[0]);}

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(510, 800, -110.0), Arguments.of(376, 700, 124.0),  Arguments.of(210, 100, 890.0),
                Arguments.of(0, 900, 300.0)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculatesAvailableLuggageWeightCorrectly(double people, double gas, double luggage ) throws InvalidClauseException {
        runWithInput(people + " "+ gas);
        assertEquals(Double.parseDouble(getItemByName("luggage")), luggage, 0.0001,
                "Your program does not calculate the allowed pounds of luggage correctly.");
    }
}
