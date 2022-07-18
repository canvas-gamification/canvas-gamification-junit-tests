package conditionals.programs_with_decision_points.medium.q9;

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
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "1944";
    return new Clause[] {
        new StringLiteral("Enter your birth year :"),
        new NewLine(),
        new PlaceHolder()
    };
  }

  public void runMain() {
    GenerationGap.main(new String[0]);
  }

  static Stream<Arguments> inputProviderValidInput() {
    return Stream.of(
        Arguments.of(1944, "Baby Boomer"),
        Arguments.of(1950, "Baby Boomer"),
        Arguments.of(1964, "Baby Boomer"),
        Arguments.of(1965, "Gen X"),
        Arguments.of(1970, "Gen X"),
        Arguments.of(1979, "Gen X"),
        Arguments.of(1980, "Millennial"),
        Arguments.of(1990, "Millennial"),
        Arguments.of(1994, "Millennial"),
        Arguments.of(1995, "Gen Z"),
        Arguments.of(2002, "Gen Z"),
        Arguments.of(2015, "Gen Z"),
        Arguments.of(1901, "Uncategorized"),
        Arguments.of(1943, "Uncategorized"),
        Arguments.of(2016, "Uncategorized"),
        Arguments.of(2030, "Uncategorized"));
  }

  static Stream<Arguments> inputProviderInvalidInput() {
    return Stream.of(
        Arguments.of(1900),
        Arguments.of(-1000),
        Arguments.of(0),
        Arguments.of(-2020),
        Arguments.of(-1));
  }

  @ParameterizedTest
  @MethodSource("inputProviderValidInput")
  public void printsCorrectGeneration(int year, String generation) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct generation for the given year.";
    runWithInput(year + "", new Clause[] {
        new StringLiteral(generation)
    });
  }

  @ParameterizedTest
  @MethodSource("inputProviderInvalidInput")
  public void printsErrorMessageWithInvalidInput(int year) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print an error message when given an invalid input.";
    runWithInput(year + "", new Clause[] {
        new StringLiteral("Invalid Input!")
    });
  }

}
