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
    TestOption.defaultInput = "10 1";
    return new Clause[] {
        new StringLiteral("How fast were you above the speed limit\\?"),
        new NewLine(),
        new StringLiteral("Were you in a school zone\\? \\(Enter 1 for True, and 0 for False\\)"),
        new NewLine(),
        new PlaceHolder(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    DrivingFines.main(new String[0]);
  }

  static Stream<Arguments> inputValidProvider() {
    return Stream.of(
        Arguments.of(1, 0, "Your fine is \\$50!"),
        Arguments.of(5, 0, "Your fine is \\$50!"),
        Arguments.of(10, 0, "Your fine is \\$50!"),
        Arguments.of(11, 0, "Your fine is \\$75!"),
        Arguments.of(15, 0, "Your fine is \\$75!"),
        Arguments.of(30, 0, "Your fine is \\$75!"),
        Arguments.of(31, 0, "Your fine is \\$100!"),
        Arguments.of(40, 0, "Your fine is \\$100!"),
        Arguments.of(50, 0, "Your fine is \\$100!"),
        Arguments.of(51, 0, "Your fine is \\$150!"),
        Arguments.of(100, 0, "Your fine is \\$150!"),
        Arguments.of(1, 1, "Your fine is \\$100!"),
        Arguments.of(5, 1, "Your fine is \\$100!"),
        Arguments.of(10, 1, "Your fine is \\$100!"),
        Arguments.of(11, 1, "Your fine is \\$150!"),
        Arguments.of(15, 1, "Your fine is \\$150!"),
        Arguments.of(30, 1, "Your fine is \\$150!"),
        Arguments.of(31, 1, "Your fine is \\$200!"),
        Arguments.of(40, 1, "Your fine is \\$200!"),
        Arguments.of(50, 1, "Your fine is \\$200!"),
        Arguments.of(51, 1, "Your fine is \\$300!"),
        Arguments.of(100, 1, "Your fine is \\$300!"));
  }

  static Stream<Arguments> inputInvalidProvider() {
    return Stream.of(
        Arguments.of(0, 0),
        Arguments.of(-1, 0),
        Arguments.of(-100, 0),
        Arguments.of(1, -1),
        Arguments.of(1, 2),
        Arguments.of(0, 2),
        Arguments.of(0, -1));
  }

  @ParameterizedTest
  @MethodSource("inputValidProvider")
  public void printsCorrectFine(int speed, int isSchoolZone, String fee) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct fee for the given speed.";
    runWithInput(speed + " " + isSchoolZone, new Clause[] {
        new StringLiteral(fee),
        new NewLine(),
    });
  }

  @ParameterizedTest
  @MethodSource("inputInvalidProvider")
  public void printsErrorMessageForInvalidSpeed(int speed, int isSchoolZone) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct fee for the given speed.";
    runWithInput(speed + " " + isSchoolZone, new Clause[] {
        new StringLiteral("Unknown inputs"),
        new NewLine(),
    });
  }
}
