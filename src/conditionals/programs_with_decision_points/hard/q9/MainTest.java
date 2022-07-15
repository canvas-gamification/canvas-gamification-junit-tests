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
    TestOption.defaultInput = "10 True";
    return new Clause[] {
        new StringLiteral("How fast were you above the speed limit\\?"),
        new NewLine(),
        new StringLiteral("Were you in a school zone\\? \\(Enter True or False\\)"),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    DrivingFines.main(new String[0]);
  }

  static Stream<Arguments> inputValidProvider() {
    return Stream.of(
        Arguments.of(1, "False", "Your fine is \\$50!"),
        Arguments.of(5, "False", "Your fine is \\$50!"),
        Arguments.of(10, "False", "Your fine is \\$50!"),
        Arguments.of(11, "False", "Your fine is \\$75!"),
        Arguments.of(15, "False", "Your fine is \\$75!"),
        Arguments.of(30, "False", "Your fine is \\$75!"),
        Arguments.of(31, "False", "Your fine is \\$100!"),
        Arguments.of(40, "False", "Your fine is \\$100!"),
        Arguments.of(50, "False", "Your fine is \\$100!"),
        Arguments.of(51, "False", "Your fine is \\$150!"),
        Arguments.of(100, "False", "Your fine is \\$150!"),
        Arguments.of(1, "True", "Your fine is \\$100!"),
        Arguments.of(5, "True", "Your fine is \\$100!"),
        Arguments.of(10, "True", "Your fine is \\$100!"),
        Arguments.of(11, "True", "Your fine is \\$150!"),
        Arguments.of(15, "True", "Your fine is \\$150!"),
        Arguments.of(30, "True", "Your fine is \\$150!"),
        Arguments.of(31, "True", "Your fine is \\$200!"),
        Arguments.of(40, "True", "Your fine is \\$200!"),
        Arguments.of(50, "True", "Your fine is \\$200!"),
        Arguments.of(51, "True", "Your fine is \\$300!"),
        Arguments.of(100, "True", "Your fine is \\$300!"));
  }

  static Stream<Arguments> inputInvalidProvider() {
    return Stream.of(
        Arguments.of(0, "False"),
        Arguments.of(-1, "False"),
        Arguments.of(-100, "False"));
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
    TestOption.incorrectStructureErrorMessage = "Your program does not print the error message for invalid input.";
    runWithInput(speed + " " + isSchoolZone, new Clause[] {
        new StringLiteral("Invalid Input!"),
    });
  }
}
