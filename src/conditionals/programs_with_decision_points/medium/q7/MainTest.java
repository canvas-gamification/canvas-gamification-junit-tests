package conditionals.programs_with_decision_points.medium.q7;

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
  // Parsons
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "12345";
    return new Clause[] {
        new StringLiteral("Enter a Javatopia ZIP code:"),
        new NewLine(),
        new PlaceHolder(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    JavaTopia.main(new String[0]);
  }

  public static Stream<Arguments> inputProviderValidInput() {
    return Stream.of(
        Arguments.of(12345, "This ZIP code belongs to String Avenue"),
        Arguments.of(14325, "This ZIP code belongs to Character County"),
        Arguments.of(22111, "This ZIP code belongs to Memory Front"),
        Arguments.of(24912, "This ZIP code belongs to RAM Ranch"));
  }

  public static Stream<Arguments> inputProviderOutsideTerritoryInput() {
    return Stream.of(
        Arguments.of(23123),
        Arguments.of(29123),
        Arguments.of(92123),
        Arguments.of(99999),
        Arguments.of(10000),
        Arguments.of(18123));
  }

  public static Stream<Arguments> inputProviderInvalidInput() {
    return Stream.of(
        Arguments.of(-12345),
        Arguments.of(01235),
        Arguments.of(1),
        Arguments.of(12),
        Arguments.of(123),
        Arguments.of(1234),
        Arguments.of(9999),
        Arguments.of(100000),
        Arguments.of(123456));
  }

  @ParameterizedTest
  @MethodSource("inputProviderValidInput")
  public void printsCorrectArea(int zipCode, String area) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct area in Javatopia for the given ZIP code.";
    runWithInput(zipCode + "", new Clause[] {
        new StringLiteral(area),
        new NewLine(),
    });
  }

  @ParameterizedTest
  @MethodSource("inputProviderOutsideTerritoryInput")
  public void printsErrorMessageForAreasOutsideTerriotry(int zipCode) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct error message for the ZIP codes outside of Javatopia.";
    runWithInput(zipCode + "", new Clause[] {
        new StringLiteral("This ZIP code does not belong to Javatopia"),
        new NewLine(),
    });
  }

  @ParameterizedTest
  @MethodSource("inputProviderInvalidInput")
  public void printsErrorMessageForInvalidInputs(int zipCode) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct error message for invalid ZIP codes.";
    runWithInput(zipCode + "", new Clause[] {
        new StringLiteral("Invalid Input!"),
        new NewLine(),
    });
  }
}
