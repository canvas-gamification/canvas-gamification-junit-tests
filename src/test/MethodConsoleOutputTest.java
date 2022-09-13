package test;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MethodConsoleOutputTest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Hello Seth"),
                new NewLine(),
                new StringLiteral("THIS WAS LOWERCASE")
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
}
