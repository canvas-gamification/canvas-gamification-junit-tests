package conditionals.programs_with_decision_points.hard.q6;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest extends BaseTest {
  // Parsons with distractors
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "1";
    return new Clause[] {
        new StringLiteral("Which year are you in\\? \\(1, 2 ,3, or 4\\) \\?"),
        new NewLine(),
        new PlaceHolder()
    };
  }

  public void runMain() {
    UniversityLife.main(new String[0]);
  }

  static Stream<Arguments> inputProviderValid() {
    return Stream.of(
        Arguments.of(1, "You're a Freshman"),
        Arguments.of(2, "You're a Sophomore"),
        Arguments.of(3, "You're a Junior"),
        Arguments.of(4, "You're a Senior"));
  }

  static Stream<Arguments> inputProviderInvalid() {
    return Stream.of(
        Arguments.of(-1),
        Arguments.of(-4),
        Arguments.of(0),
        Arguments.of(5),
        Arguments.of(6));
  }

  @ParameterizedTest
  @MethodSource("inputProviderValid")
  public void printsCorrectUniversityStatusWithValidInput(int year, String universityStatus) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct university status for the given year.";
    runWithInput(year + "", new Clause[]{
      new StringLiteral(universityStatus)
    });
  }

  @ParameterizedTest
  @MethodSource("inputProviderInvalid")
  public void printsErrorMessageFor(int invalidYear) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the error message for the invalid year.";
    runWithInput(invalidYear + "", new Clause[]{
      new StringLiteral("Invalid Input!")
    });
  }
}
