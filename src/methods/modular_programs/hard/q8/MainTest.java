package methods.modular_programs.hard.q8;

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
        TestOption.defaultInput = "Hello world";
        return new Clause[]{
                new StringLiteral("Enter a sentence:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Total number of Characters in the sentence: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        CounterChar.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Hello World", 10),
                Arguments.of("Hello World!!!", 13),
                Arguments.of("                      Hello                 ", 5),
                Arguments.of("123HelloWorld!!!", 16),
                Arguments.of("12  3H ello W o r  l    d! !! ", 16),
                Arguments.of("!", 1),
                Arguments.of(" ", 0),
                Arguments.of("             !            ", 1),
                Arguments.of("                         ", 0),
                Arguments.of("@@@@@@@@@@@@@@@@@@@@@@@@@@", 26));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctCharCounterMethod(String str, int numChars) throws Throwable {
        Object[][] arguments = {
                {str, String.class}
        };
        MethodTest m = new MethodTest(CounterChar.class, "charCounter", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(numChars, output, "Your charCounter method does not return the correct number of characters in the sentence.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsCorrectOutput(String str, int numChars) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct number of characters for the given input.";
        runWithInput(str, new Clause[]{
                new IntegerLiteral(numChars),
        });
    }
}
