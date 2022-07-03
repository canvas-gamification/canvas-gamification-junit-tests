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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    //Parson
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "510 800 300 ";
        return new Clause[]{
                new StringLiteral("How much do all the travellers weigh\\?"),
                new NewLine(),
                new StringLiteral("How much does the gas weigh for the return flight\\?"),
                new NewLine(),
                new StringLiteral("What is the total weight of luggage from all travelers\\?"),
                new NewLine(),
                new StringLiteral("You can bring back "),
                new DoubleLiteral("souvenir"),
                new StringLiteral(" pounds of souvenirs\\!")
        };
    }

    public void runMain(){ PiperSaratoga.main(new String[0]);}

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(510, 800, 300, -10.0), Arguments.of(376, 700, 150, 324.0)
                , Arguments.of(210, 100, 500, 440.0), Arguments.of(0, 700, 800, 50.0)
                , Arguments.of(330, 222, 5, 754.0)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculateAvailableSouvenirsPounds(double people, double gas, double bags, double souvenir ){
        runWithInput(people + " "+ gas + " " + bags);
        assertEquals(Double.parseDouble(getItemByName("souvenir")), souvenir, "Incorrect printing out the allowed pounds of souvenirs.");
    }
}
