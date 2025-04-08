package conditionals.programs_with_decision_points.medium.q10;
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
        TestOption.defaultInput = "s";
        return new Clause[]{
                new StringLiteral("Enter a character: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        CoffeeOrder.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("s", "small"), Arguments.of("t", "tall"), Arguments.of("g", "grande"),
                Arguments.of("v", "venti"), Arguments.of("r", "trenta"), Arguments.of("6", "Invalid. Please enter a valid character."));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String charString, String sizeOutput) throws InvalidClauseException {
        //add test option structure error message
        runWithInput(charString, new Clause[]{
                new StringLiteral(sizeOutput)
        });
    }

}

