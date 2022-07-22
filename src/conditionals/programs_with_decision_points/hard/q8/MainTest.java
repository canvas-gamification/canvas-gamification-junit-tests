package conditionals.programs_with_decision_points.hard.q8;

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
  // Parsons with distractors
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "500";
    return new Clause[] {
        new StringLiteral("How many points did you score\\?"),
        new NewLine(),
        new PlaceHolder()
    };
  }

  public void runMain() {
    PointsScoring.main(new String[0]);
  }

  public static Stream<Arguments> inputProviderValid() {
    return Stream.of(
        Arguments.of("10000", "You won a gold prize!"),
        Arguments.of("5000", "You won a gold prize!"),
        Arguments.of("4999", "You won a silver prize!"),
        Arguments.of("4000", "You won a silver prize!"),
        Arguments.of("2500", "You won a silver prize!"),
        Arguments.of("2499", "You won a bronze prize!"),
        Arguments.of("1999", "You won a bronze prize!"),
        Arguments.of("1000", "You won a bronze prize!"),
        Arguments.of("999", "Sorry, you didn't win any prize."),
        Arguments.of("500", "Sorry, you didn't win any prize."),
        Arguments.of("0", "Sorry, you didn't win any prize."));
  }

  public static Stream<Arguments> inputProviderInvalid() {
    return Stream.of(
        Arguments.of("-1"),
        Arguments.of("-100"),
        Arguments.of("-1000"),
        Arguments.of("-10000"));
  }

  @ParameterizedTest
  @MethodSource("inputProviderValid")
  public void printsCorrectMessageWithValidInput(int score, String prize) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct prize for the given score.";
    runWithInput(score + " ", new Clause[] {
        new StringLiteral(prize)
    });
  }

  @ParameterizedTest
  @MethodSource("inputProviderInvalid")
  public void printsErrorMessageWithInvalidInput(int score) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print an error message when given an invalid score.";
    runWithInput(score + " ", new Clause[] {
        new StringLiteral("Invalid Input!")
    });
  }
}
