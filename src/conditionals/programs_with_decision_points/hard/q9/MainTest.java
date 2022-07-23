package conditionals.programs_with_decision_points.hard.q9;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Parsons with distractors
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "10 true";
    return new Clause[] {
        new StringLiteral("How fast were you above the speed limit\\?"),
        new NewLine(),
        new StringLiteral("Were you in a school zone\\? \\(Enter true or false\\)"),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    DrivingFines.main(new String[0]);
  }

  static Stream<Arguments> inputValidProvider() {
    return Stream.of(
        Arguments.of(1, "false", "Your fine is \\$50!"),
        Arguments.of(5, "false", "Your fine is \\$50!"),
        Arguments.of(10, "false", "Your fine is \\$50!"),
        Arguments.of(11, "false", "Your fine is \\$75!"),
        Arguments.of(15, "false", "Your fine is \\$75!"),
        Arguments.of(30, "false", "Your fine is \\$75!"),
        Arguments.of(31, "false", "Your fine is \\$100!"),
        Arguments.of(40, "false", "Your fine is \\$100!"),
        Arguments.of(50, "false", "Your fine is \\$100!"),
        Arguments.of(51, "false", "Your fine is \\$150!"),
        Arguments.of(100, "false", "Your fine is \\$150!"),
        Arguments.of(1, "true", "Your fine is \\$100!"),
        Arguments.of(5, "true", "Your fine is \\$100!"),
        Arguments.of(10, "true", "Your fine is \\$100!"),
        Arguments.of(11, "true", "Your fine is \\$150!"),
        Arguments.of(15, "true", "Your fine is \\$150!"),
        Arguments.of(30, "true", "Your fine is \\$150!"),
        Arguments.of(31, "true", "Your fine is \\$200!"),
        Arguments.of(40, "true", "Your fine is \\$200!"),
        Arguments.of(50, "true", "Your fine is \\$200!"),
        Arguments.of(51, "true", "Your fine is \\$300!"),
        Arguments.of(100, "true", "Your fine is \\$300!"));
  }

  static Stream<Arguments> inputInvalidProvider() {
    return Stream.of(
        Arguments.of(0, "false"),
        Arguments.of(-1, "false"),
        Arguments.of(-100, "false"));
  }

  @ParameterizedTest
  @MethodSource("inputValidProvider")
  public void printsCorrectFine(int speed, String isSchoolZone, String fine) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct fee for the given speed.";
    runWithInput(speed + " " + isSchoolZone, new Clause[] {
        new StringLiteral(fine),
    });
  }

  @ParameterizedTest
  @MethodSource("inputInvalidProvider")
  public void printsErrorMessageForInvalidSpeed(int speed, String isSchoolZone) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print an error message for an invalid input.";
    runWithInput(speed + " " + isSchoolZone, new Clause[] {
        new StringLiteral("Invalid Input!"),
    });
  }
}
