package methods.defining_methods.hard.q3;

import java.util.stream.Stream;

import global.MethodTest;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "8";

        return new Clause[]{
                new StringLiteral("Enter the number of sides on the polygon:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        Polygo.main(new String[0]);
    }

    static Stream<Arguments> innerAnglesInputProvider() {
        return Stream.of(
                Arguments.of(8, 1080),
                Arguments.of(3, 180),
                Arguments.of(100, 17640),
                Arguments.of(10000, 1799640),
                Arguments.of(2, -1),
                Arguments.of(0, -1),
                Arguments.of(-50, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("innerAnglesInputProvider")
    void correctInnerAnglesMethod(int a, int innerAngles) throws Throwable {
        Object[][] arguments = {
                {a, int.class}
        };
        MethodTest m = new MethodTest(Polygo.class, "innerAngles", arguments);
        Object output = m.callMethod();
        String errorMessage = "Your innerAngles() method does not correctly calculate the inner angles of a polygon in degrees.";
        CustomAssertions._assertEquals(innerAngles, output, errorMessage);
    }

    @ParameterizedTest
    @MethodSource("innerAnglesInputProvider")
    void printsOutputCorrectly(int a, int innerAngles) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly calculate and print the inner angles of a polygon in degrees.";
        runWithInput(a + "", new Clause[][]{{
                new StringLiteral("The sum of interior angles of the polygon is\\: "),
                new IntegerLiteral(innerAngles)
        }});
    }
}
