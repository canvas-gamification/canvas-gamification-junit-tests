package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q10;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    //Parson
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "510 400 3 45";
        return new Clause[]{
                new StringLiteral("How much do all the travellers weigh?"),
                new NewLine(),
                new StringLiteral("How much does the gas weigh for the return flight?"),
                new NewLine(),
                new StringLiteral("How much luggage are you bringing and what does it weigh?"),
                new NewLine(),
                new StringLiteral("You can bring back "),
                new DoubleLiteral("gift"),
                new StringLiteral(" pounds of souvenirs!")
        };
    }

    public void runMain(){ PiperSaratoga.main(new String[0]);}

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(510, 800, 300));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculateAvailableSouvenirsPounds(double people, double gas, double bags ){
        runWithInput(people + System.lineSeparator() + gas + System.lineSeparator() + bags);


    }
}
