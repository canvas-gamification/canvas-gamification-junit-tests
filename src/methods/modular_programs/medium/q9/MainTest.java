package methods.modular_programs.medium.q9;

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
    TestOption.defaultInput = "10 5";

    return new Clause[] {
        new StringLiteral("Enter the first number: "),
        new NewLine(),
        new StringLiteral("Enter the second number: "),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    MaxItOut.main(new String[0]);
  }

  static Stream<Arguments> inputDivisibleProvider() {
    return Stream.of(
        Arguments.of(10, 5, 10),
        Arguments.of(20, 2, 20),
        Arguments.of(200, -10, 200),
        Arguments.of(0, -3789123, 0),
        Arguments.of(0, 5, 5),
        Arguments.of(5, 10, 10),
        Arguments.of(2, 20, 20),
        Arguments.of(-10, 200, 200));
  }

  static Stream<Arguments> inputNotDivisibleProvider() {
    return Stream.of(
        Arguments.of(10, 4),
        Arguments.of(20, -3),
        Arguments.of(-201, 10),
        Arguments.of(6, 7));
  }

  @ParameterizedTest
  @MethodSource("inputDivisibleProvider")
  void methodReturnCorrectLargerNumber(int n1, int n2, int larger) throws Throwable {
    String errMsg = "Your method \"maxOut()\" does not return the correct larger number.";
    Object output = MethodUtil.invokeIfMethodExists(MaxItOut.class, "maxOut", new Object[] { n1, n2 }, int.class,
        int.class);
    CustomAssertions._assertEquals(output, larger + " is the max", errMsg);
  }

  @ParameterizedTest
  @MethodSource("inputNotDivisibleProvider")
  void methodReturnNotDivisible(int n1, int n2) throws Throwable {
    String errMsg = "Your method \"maxOut()\" does not return \"Not divisible\".";
    Object output = MethodUtil.invokeIfMethodExists(MaxItOut.class, "maxOut", new Object[] { n1, n2 }, int.class,
        int.class);
    CustomAssertions._assertEquals(output, "Not divisible", errMsg);
  }

  @ParameterizedTest
  @MethodSource("inputDivisibleProvider")
  void printsCorrectOutputDivisible(int n1, int n2, int larger) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct larger number for the given input.";
    runWithInput(n1 + " " + n2, new Clause[][] { {
        new IntegerLiteral(larger),
        new StringLiteral(" is the max"),
    } });
  }

  @ParameterizedTest
  @MethodSource("inputNotDivisibleProvider")
  void printsCorrectOutputNotDivisible(int n1, int n2) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message for nondivisible numbers.";
    runWithInput(n1 + " " + n2, new Clause[] {
        new StringLiteral("Not divisible"),
    });
  }
}
