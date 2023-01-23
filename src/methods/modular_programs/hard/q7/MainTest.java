package methods.modular_programs.hard.q7;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Hello World";
        return new Clause[]{
                new StringLiteral("Enter a sentence:"),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        RevUp.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Hello World", "dlroW olleH"),
                Arguments.of("Hello World!", "!dlroW olleH"),
                Arguments.of("1232222", "2222321"),
                Arguments.of("12345@A67890", "09876A@54321"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void methodReturnsCorrectRev(String str, String revStr) throws Throwable {
        Object[][] arguments = {
                {str, String.class}
        };
        MethodTest m = new MethodTest(RevUp.class, "revString", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(revStr, output, "Your revString method does not correctly reverse the string.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsCorrectOutput(String str, String revStr) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct reversed string for the given input.";
        runWithInput(str, new Clause[]{
                new StringLiteral("Your sentence in reverse is: " + revStr)
        });
    }
}
