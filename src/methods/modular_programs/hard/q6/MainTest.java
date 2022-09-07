package methods.modular_programs.hard.q6;

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
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "120 N";
    return new Clause[] {
        new StringLiteral("How much was the food"),
        new NewLine(),
        new StringLiteral("Was the service great\\? \\(Enter Y\\/N\\)"),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    DinnerCost.main(new String[0]);
  }

  static Stream<Arguments> inputProvider() {
    return Stream.of(
        Arguments.of(120.0, 'N', 138.0),
        Arguments.of(120.0, 'Y', 144.0),
        Arguments.of(100.0, 'N', 115.0),
        Arguments.of(100.0, 'Y', 120.0),
        Arguments.of(0.0, 'N', 0.0),
        Arguments.of(0.0, 'Y', 0.0),
        Arguments.of(1000.0, 'N', 1150.0),
        Arguments.of(1000.0, 'Y', 1200.0),
        Arguments.of(7877.0, 'N', 9058.55),
        Arguments.of(7877.0, 'Y', 9452.4),
        Arguments.of(3.0, 'Y', 3.6),
        Arguments.of(3.0, 'N', 3.45),
        Arguments.of(111.223, 'Y', 133.4676),
        Arguments.of(92.121, 'N', 105.93915),
        Arguments.of(3.33, 'Y', 3.996),
        Arguments.of(3.51, 'N', 4.0365));
  }

  @ParameterizedTest
  @MethodSource("inputProvider")
  public void methodReturnsCorrectTotal(double costOfFood, char service, double totalCost) throws Throwable {
    String errMsg = "Your method \"foodCost()\" does not return the correct total cost for the given input.";
    String errMsgOut = "Your method \"foodCost\" prints to the console, which is not allowed.";

    Object output = MethodUtil.invokeIfMethodExists(DinnerCost.class, "foodCost", new Object[] { service, costOfFood },
        char.class, double.class);
    String consoleOutput = MethodUtil.getMethodOutput().trim();

    CustomAssertions._assertEquals(totalCost, output, 0.001, errMsg);
    CustomAssertions._assertEquals("", consoleOutput, errMsgOut);
  }

  @ParameterizedTest
  @MethodSource("inputProvider")
  public void printsCorrectDinnerCost(double costOfFood, char service, double totalCost)
      throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct total cost of dinner for the given input.";
    double delta = 0.001;
    runWithInput(costOfFood + " " + service, new Clause[][] { {
        new StringLiteral("For dinner, you will pay "),
        new DoubleLiteral(totalCost - delta, totalCost + delta),
        new StringLiteral(" dollars."),
    } });
  }
}
