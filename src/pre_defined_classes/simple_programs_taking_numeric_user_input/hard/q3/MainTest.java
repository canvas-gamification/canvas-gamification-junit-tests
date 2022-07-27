package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q3;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10 20 30";
        return new Clause[]{
                new StringLiteral("Enter three integers: "),
                new StringLiteral("The oldest age is: "),
                new IntegerLiteral("max")
        };
    }

    public void runMain() {
        OldFolks.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(10, 20, 30, 30), Arguments.of(46, 78, 11, 78), Arguments.of(57, 14, 39, 57),
                Arguments.of(50,50,50,50));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculatesMaximumAgeCorrectly(int n1, int n2, int n3, int max) throws InvalidClauseException {
        runWithInput(n1 + System.lineSeparator() + n2 + System.lineSeparator() + n3);
        assertEquals(Integer.parseInt(getItemByName("max")), max, "Your program does not correctly calculate the maximum age.");
    }
}
