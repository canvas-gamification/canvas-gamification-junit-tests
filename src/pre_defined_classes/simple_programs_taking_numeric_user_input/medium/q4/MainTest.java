package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q4;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "2022 2002";
        return new Clause[]{
                new StringLiteral("What is the current year\\?"),
                new NewLine(),
                new StringLiteral("What year were you born in\\?"),
                new NewLine(),
                new StringLiteral("You are "),
                new IntegerLiteral("age"),
                new StringLiteral(" years old this year\\!")
        };
    }

    public void runMain() {
        Age.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(2022, 2002, 20), Arguments.of(1986, 1849, 137), Arguments.of(2001, 1947, 54),
                Arguments.of(2022, 2022, 0), Arguments.of(2017, 2010, 7));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctlyCalculatesAge(int current, int birthYear, int age){
        runWithInput(current + System.lineSeparator() + birthYear);
        assertEquals(Integer.parseInt(getItemByName("age")), age, "Your program does not calculate age correctly.");
    }
}
