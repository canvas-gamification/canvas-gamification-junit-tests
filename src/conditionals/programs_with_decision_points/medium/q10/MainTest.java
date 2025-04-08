package conditionals.programs_with_decision_points.medium.q10;

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
    TestOption.defaultInput = "1";
    return new Clause[] {
        new StringLiteral("Enter a size (1-5): "),
        new NewLine(),
        new PlaceHolder()
    };
  }

  public void runMain() {
    CoffeeOrder.main(new String[0]);
  }

  static Stream<Arguments> inputProviderValidInput() {
    return Stream.of(
        Arguments.of("1", "small"),
        Arguments.of("2", "tall"),
        Arguments.of("3", "grande"),
        Arguments.of("4", "venti"),
        Arguments.of("5", "trenta"));
  }

  static Stream<Arguments> inputProviderInvalidInput() {
    return Stream.of(
        Arguments.of(6));
  }

  @ParameterizedTest
  @MethodSource("inputProviderValidInput")
  public void printsCorrectSize(String num, String size ) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct size for the given number.";
    runWithInput(num + "", new Clause[] {
        new StringLiteral(size)
    });
  }

}
