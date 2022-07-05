package conditionals.programs_with_decision_points.medium.q8;

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
  // Parsons
  @Override
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "1";
    return new Clause[] {
        new StringLiteral("Which place did you finish\\? \\(Ex. 1, 2, 3, etc\\)\\:"),
        new NewLine(),
        new PlaceHolder(),
        new PlaceHolder(),
    };
  }

  @Override
  public void runMain() {
    Competition.main(new String[0]);
  }

  static Stream<Arguments> inputProviderValidInput() {
    return Stream.of(
        Arguments.of(1, "You won the Gold Trophy!"),
        Arguments.of(2, "You won the Silver Trophy!"),
        Arguments.of(3, "You won the Bronze Trophy!"),
        Arguments.of(4, "You won the Consolation Goodie Bag!"),
        Arguments.of(5, "You won the Consolation Goodie Bag!"));
  }

  static Stream<Arguments> inputProviderInvalid() {
    return Stream.of(
        Arguments.of(0),
        Arguments.of(-1));
  }

  @ParameterizedTest
  @MethodSource("inputProviderValidInput")
  public void printsCorrectPrize(int place, String prize) throws InvalidClauseException {
    System.out.println("place: " + place);
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct prize for the given place.";
    runWithInput(place + "", new Clause[] {
        new StringLiteral(prize),
        new NewLine(),
    });
  }

  @ParameterizedTest
  @MethodSource("inputProviderInvalid")
  public void printsErrorMessageForInvalidPlace(int place) throws InvalidClauseException {
    System.out.println("place: " + place);
    TestOption.incorrectStructureErrorMessage = "Your program does not print the error message for the invalid place.";
    runWithInput(place + "", new Clause[] {
        new StringLiteral("Invalid Input!"),
        new NewLine(),
    });
  }
}