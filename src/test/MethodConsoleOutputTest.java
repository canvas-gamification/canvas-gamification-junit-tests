package test;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MethodConsoleOutputTest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Hello Seth"),
                new NewLine(),
                new StringLiteral("THIS WAS LOWERCASE"),
                new NewLine(),
                new StringLiteral("The sum of "),
                new IntegerLiteral("x"),
                new StringLiteral(" and "),
                new IntegerLiteral("y"),
                new StringLiteral(" is "),
                new IntegerLiteral("sum")
        };
    }

    public void runMain() {
        MethodConsoleOutput.main(new String[0]);
    }

    public static Stream<String> inputProvider(){
        return Stream.of(
                "Hello Seth",
                "Hello world"
        );
    }

    public static Stream<Arguments> sumInputProvider(){
        return Stream.of(
            Arguments.of(1, 3, 4),
            Arguments.of(12, 13, 25)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void outputTest(String input) throws Throwable {
        TestOption.defaultMethodConsoleOutput = input + System.lineSeparator();
        TestOption.incorrectMethodConsoleOutputMessage = "Your printMessage method does nor print the message passed to the method.";
        MethodUtil.invokeIfMethodExists(MethodConsoleOutput.class, "printMessage", new Object[]{input}, String.class);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void toUpperCaseTest(String message) throws Throwable {
        String expected = message.toUpperCase();
        Object actual = MethodUtil.invokeIfMethodExists(MethodConsoleOutput.class, "stringToUpper", new Object[]{message}, String.class);
        CustomAssertions._assertEquals(expected, actual, "Whoops");
    }

    @ParameterizedTest
    @MethodSource("sumInputProvider")
    void sumMethodTest(int x, int y, int sum) throws Throwable {
        String correctOutput = String.format("The sum of %d and %d is %d\n", x, y, sum);
        TestOption.defaultMethodConsoleOutput = correctOutput;
        Object output = MethodUtil.invokeIfMethodExists(MethodConsoleOutput.class, "sum", new Object[]{x, y},
                int.class, int.class);
        CustomAssertions._assertEquals(sum, output, "Your sum method does not correctly calculate the sum of two integers.");
    }

}
