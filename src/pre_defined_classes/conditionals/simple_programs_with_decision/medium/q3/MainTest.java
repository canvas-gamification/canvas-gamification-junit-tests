package pre_defined_classes.conditionals.simple_programs_with_decision.medium.q3;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.InvalidClassException;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "19";
        return new Clause[]{
                new StringLiteral("What is your age\\? "),
                new NewLine(),
                new StringLiteral(".*", "underAge")
        };
    }

    public void runMain() {
        VirtualBouncer.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(19,  "Step right in sir."), Arguments.of(18, "Whoa there kiddo, it's past your bedtime."));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(int input, String output) throws InvalidClassException{
        runWithInput(input + "");
        String errorMessage = "Output string incorrect for age 18 or below" ;
        if(input >= 19)
            errorMessage = "Output string incorrect for age 19 or above";
        assertEquals(getItemByName("underAge"), output, errorMessage);
    }
}
