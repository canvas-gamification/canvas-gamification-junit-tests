package methods.modular_programs.hard.q8;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
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
    return new Clause[] {
        new StringLiteral("Enter a sentence"),
        new NewLine(),
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
        Arguments.of("@@@@@@@@@@@@@@@@@@@@@@@@@@", 26));
  }

  @ParameterizedTest
  @MethodSource("inputProvider")
  public void methodReturnsCorrectNumberOfChars(String str, int numChars) throws Throwable {
    String errMsg = "Your method \"charCounter()\" does not return the correct number of characters for the given input.";
    String errMsgOut = "Your method \"charCounter()\" prints to console, which is not allowed.";

    Object output = MethodUtil.invokeIfMethodExists(CounterChar.class, "charCounter", new Object[] { str },
        String.class);
    Object consoleOutput = MethodUtil.getMethodOutput().trim();

    CustomAssertions._assertEquals(numChars, output, errMsg);
    CustomAssertions._assertEquals("", consoleOutput, errMsgOut);
  }

  @ParameterizedTest
  @MethodSource("inputProvider")
  public void printsCorrectNumberOfChars(String str, int numChars) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct number of characters for the given input.";
    runWithInput(str, new Clause[][] { {
        new StringLiteral("Total number of Characters in the sentence: "),
        new IntegerLiteral(numChars),
    } });
  }
}
