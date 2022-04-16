package conditionals.programs_with_decision_points.medium.q1;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "a";

        return new Clause[]{
                new StringLiteral("Enter a character: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        LetterBox.main(new String[0]);
    }

    //turn into three seperate tests
    //use the new error message idea
    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("a", "a is a lowercase letter"), Arguments.of("z", "z is a lowercase letter"), Arguments.of("A", "A is an uppercase letter"), Arguments.of("Z", "Z is an uppercase letter"), Arguments.of("&", "& is neither uppercase not lowercase"), Arguments.of("/", "/ is neither uppercase not lowercase"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String input, String message) throws InvalidClauseException {


        runWithInput(input, new Clause[]{
                new StringLiteral(message)
        });
    }
}
