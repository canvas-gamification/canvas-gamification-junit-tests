package conditionals.programs_with_decision_points.hard.q7;

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
    TestOption.defaultInput = "1000";
    return new Clause[] {
        new StringLiteral("How many people are in your area\\?"),
        new NewLine(),
        new PlaceHolder()
    };
  }

  public void runMain() {
    RiskyBusiness.main(new String[0]);
  }

  static Stream<Arguments> inputProviderValid() {
    return Stream.of(
        Arguments.of(1, "Low Risk"),
        Arguments.of(489, "Low Risk"),
        Arguments.of(999, "Low Risk"),
        Arguments.of(1000, "Moderate Risk"),
        Arguments.of(5678, "Moderate Risk"),
        Arguments.of(9999, "Moderate Risk"),
        Arguments.of(10000, "High Risk"),
        Arguments.of(234908, "High Risk"),
        Arguments.of(1000000, "High Risk"));
  }

  static Stream<Arguments> inputProviderInvalid() {
    return Stream.of(
        Arguments.of(0),
        Arguments.of(-1));
  }

  @ParameterizedTest
  @MethodSource("inputProviderValid")
  public void printsCorrectRiskLevelWithValidInput(int population, String riskLevel) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct risk level with the given valid input.";
    runWithInput(population + "", new Clause[] {
        new StringLiteral(riskLevel)
    });
  }

  @ParameterizedTest
  @MethodSource("inputProviderInvalid")
  public void printsErrorMessageWithInvalidInput(int population) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the error message for invalid input.";
    runWithInput(population + "", new Clause[] {
        new StringLiteral("Invalid Input!")
    });
  }
}
