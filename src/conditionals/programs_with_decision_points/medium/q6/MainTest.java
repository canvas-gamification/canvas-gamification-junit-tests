package conditionals.programs_with_decision_points.medium.q6;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "w";
    return new Clause[] {
        new StringLiteral("Enter w, a, s, or d :"),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    Gamer.main(new String[0]);
  }

  static Stream<Arguments> inputProviderInvalidInput() {
    return Stream.of(
      Arguments.of("b", "Invalid Input!"),
      Arguments.of("c", "Invalid Input!"),
      Arguments.of("e", "Invalid Input!"),
      Arguments.of("f", "Invalid Input!"),
      Arguments.of("g", "Invalid Input!"),
      Arguments.of("h", "Invalid Input!"),
      Arguments.of("i", "Invalid Input!"),
      Arguments.of("j", "Invalid Input!"),
      Arguments.of("k", "Invalid Input!"),
      Arguments.of("l", "Invalid Input!"),
      Arguments.of("m", "Invalid Input!"),
      Arguments.of("n", "Invalid Input!"),
      Arguments.of("o", "Invalid Input!"),
      Arguments.of("p", "Invalid Input!"),
      Arguments.of("q", "Invalid Input!"),
      Arguments.of("r", "Invalid Input!"),
      Arguments.of("t", "Invalid Input!"),
      Arguments.of("u", "Invalid Input!"),
      Arguments.of("v", "Invalid Input!"),
      Arguments.of("x", "Invalid Input!"),
      Arguments.of("y", "Invalid Input!"),
      Arguments.of("z", "Invalid Input!"),
      Arguments.of("A", "Invalid Input!"),
      Arguments.of("\\", "Invalid Input!")
    );
  }

  static Stream<Arguments> inputProviderValidInput() {
    return Stream.of(
        Arguments.of("a", "Move Left"),
        Arguments.of("d", "Move Right"),
        Arguments.of("s", "Crouch"),
        Arguments.of("w", "Jump"),
        Arguments.of("we", "Jump")
    );
  }

  @ParameterizedTest
  @MethodSource("inputProviderValidInput")
  void printsCorrectCost(String direction, String action) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct action for one of the directions.";
    runWithInput(direction, new Clause[] {
        new StringLiteral(action),
    });
  }

  @ParameterizedTest
  @MethodSource("inputProviderInvalidInput")
  void printsErrorMessage(String direction) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program prints an error message when user inputs a character that is not a direction.";
    runWithInput(direction, new Clause[] {
        new StringLiteral("Invalid Input!")
    });
  }
}
