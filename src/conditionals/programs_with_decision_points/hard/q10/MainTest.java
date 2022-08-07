package conditionals.programs_with_decision_points.hard.q10;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
  // Parsons with distractors
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "100 1";
    return new Clause[] {
        new StringLiteral("How much was the food\\?"),
        new NewLine(),
        new StringLiteral("Was the service good\\? \\(Enter 1 for Yes, and 0 for No\\)"),
        new NewLine(),
        new PlaceHolder()
    };
  }

  public void runMain() {
    DinnerCost.main(new String[0]);
  }

  public static Stream<Arguments> inputProviderValid() {
    return Stream.of(
        Arguments.of(100, 1, 120),
        Arguments.of(100, 0, 115),
        Arguments.of(420.420, 1, 505),
        Arguments.of(420.420, 0, 483),
        Arguments.of(0, 1, 0),
        Arguments.of(0, 0, 0));
  }

  public static Stream<Arguments> inputProviderInvalid() {
    return Stream.of(
        Arguments.of(100, -1),
        Arguments.of(100, 2),
        Arguments.of(-1, 0),
        Arguments.of(-1, 1),
        Arguments.of(-1, -1),
        Arguments.of(-1, 2));
  }

  @ParameterizedTest
  @MethodSource("inputProviderValid")
  public void calculatesCorrectDinnerCost(double cost, int isGoodService, int totalCost) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct dinner cost for the given input.";
    runWithInput(cost + " " + isGoodService, new Clause[][] {{
        new StringLiteral("For dinner, you will pay "),
        new IntegerLiteral(totalCost),
        new StringLiteral(" dollars.")
    }});
  }

  @ParameterizedTest
  @MethodSource("inputProviderInvalid")
  public void printsErrorMessageWithInvalidInput(double cost, int isGoodService) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print an error message when given invalid input.";
    runWithInput(cost + " " + isGoodService, new Clause[] {
        new StringLiteral("Invalid Input!")
    });
  }
}
