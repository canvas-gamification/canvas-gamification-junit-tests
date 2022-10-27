package methods.defining_methods.hard.q4;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java

  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "5 10";
    return new Clause[] {
        new StringLiteral("Enter the first number: "),
        new StringLiteral("Enter the second number: "),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    GreaterThan.main(new String[0]);
  }

  static Stream<Arguments> correctInputProvider() {
    return Stream.of(
        Arguments.of(1, 2, 2),
        Arguments.of(2, 1, 2),
        Arguments.of(-1, -2, -1),
        Arguments.of(-2, -1, -1),
        Arguments.of(-1, 0, 0),
        Arguments.of(0, -1, 0),
        Arguments.of(0, 0, 0),
        Arguments.of(-1, 1, 1),
        Arguments.of(1, -1, 1),
        Arguments.of(1000, 999, 1000),
        Arguments.of(1, -1000, 1));
  }

  @ParameterizedTest
  @MethodSource("correctInputProvider")
  void correctGreaterNumMethod(int a, int b, int greater) throws Throwable {
    Object[][] arguments = {
            {a, int.class},
            {b, int.class}
    };
    MethodTest m = new MethodTest(GreaterThan.class, "greaterNum", arguments);
    Object output = m.callMethod();
    String errorMessage = "Your greaterNum() method does not return the greater number.";
    CustomAssertions._assertEquals(greater, output, errorMessage);
  }

  @ParameterizedTest
  @MethodSource("correctInputProvider")
  void printsCorrectGreaterNum(int a, int b, int greater) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct greater number.";
    runWithInput(a + " " + b, new Clause[][] { {
        new StringLiteral("The greater number is "),
        new IntegerLiteral(greater),
    } });
  }
}