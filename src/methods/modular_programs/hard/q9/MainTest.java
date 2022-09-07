package methods.modular_programs.hard.q9;

import java.util.Objects;
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
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "5";
    return new Clause[] {
        new StringLiteral("Enter number of lines\\: "),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    TryAngleButReflected.main(new String[0]);
  }

  static Stream<Arguments> inputValidManualProvider() {
    return Stream.of(
        Arguments.of(5, "1 2 3 4 5 \n1 2 3 4 \n1 2 3 \n1 2 \n1 \n"),
        Arguments.of(3, "1 2 3 \n1 2 \n1 \n"),
        Arguments.of(1, "1 \n"));
  }

  private static String validInputGenerator(int n) {
    StringBuilder str = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= (n - i + 1); j++)
        str.append(j + " ");
      str.append("\n");
    }
    return str.toString();
  }

  static Stream<Arguments> inputValidGeneratedProvider() {
    return Stream.of(
        Arguments.of(100, validInputGenerator(100)),
        Arguments.of(50, validInputGenerator(50)),
        Arguments.of(33, validInputGenerator(33)));
  }

  static Stream<Arguments> inputValidProvider() {
    return Stream.concat(inputValidManualProvider(), inputValidGeneratedProvider());
  }

  static Stream<Integer> inputInvalidProvider() {
    return Stream.of(-1, -2, -10, -100);
  }

  @ParameterizedTest
  @MethodSource("inputValidProvider")
  public void methodReturnsCorrectPattern(int n, String pattern) throws Throwable {
    String errMsg = "Your method \"printPattern()\" returns a value, which is not allowed.";
    String errMsgOut = "Your method \"printPattern()\" does not print the correct pattern for the given input.";

    Object output = MethodUtil.invokeIfMethodExists(TryAngleButReflected.class, "printPattern", new Object[] { n },
        int.class);
    String consoleOutput = MethodUtil.getMethodOutput();

    CustomAssertions._assertTrue(Objects.isNull(output), errMsg, errMsg);
    CustomAssertions._assertEquals(pattern.trim(), consoleOutput.trim(), errMsgOut);
  }

  @ParameterizedTest
  @MethodSource("inputInvalidProvider")
  public void methodPrintsErrorForInvalidInput(int n) throws Throwable {
    String errMsg = "Your method \"printPattern()\" returns a value, which is not allowed.";
    String errMsgOut = "Your method \"printPattern()\" does not print an error message for the given input.";

    Object output = MethodUtil.invokeIfMethodExists(TryAngleButReflected.class, "printPattern", new Object[] { n },
        int.class);
    String consoleOutput = MethodUtil.getMethodOutput();

    CustomAssertions._assertTrue(Objects.isNull(output), errMsg, errMsg);
    CustomAssertions._assertEquals("Number must be positive", consoleOutput.trim(), errMsgOut);
  }

  @ParameterizedTest
  @MethodSource("inputValidProvider")
  public void printsCorrectPatternValidInput(int n, String pattern) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct pattern for the given input.";

    String[] lines = pattern.split("\n");
    Clause[][] clauses = new Clause[1][lines.length * 2];
    for (int i = 0; i < lines.length; i++) {
      clauses[0][i * 2] = new StringLiteral(lines[i].replace("\n", ""));
      // add new line clause to the end of each line
      clauses[0][i * 2 + 1] = new NewLine();
    }

    runWithInput(n + "", clauses);
  }

  @ParameterizedTest
  @MethodSource("inputInvalidProvider")
  public void printsErrorForInvalidInput(int n) throws InvalidClauseException {
  TestOption.incorrectStructureErrorMessage = "Your program does not print an error message for the given input.";
  runWithInput(n + "", new Clause[] {
  new StringLiteral("Number must be positive"),
  });
  }
}
