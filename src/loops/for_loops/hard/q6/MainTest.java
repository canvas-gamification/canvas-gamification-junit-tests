package loops.for_loops.hard.q6;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Parsons
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "3";
    return new Clause[] {
        new StringLiteral("Enter a number\\: "),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    Factorial.main(new String[0]);
  }

  static Stream<Arguments> inputProviderValid() {
    return Stream.of(
        Arguments.of(0, 1),
        Arguments.of(1, 1),
        Arguments.of(2, 2),
        Arguments.of(3, 6),
        Arguments.of(6, 720),
        Arguments.of(8, 40320),
        Arguments.of(12, 479001600));
  }

  static Stream<Integer> inputProviderInvalid() {
    return Stream.of(-1, -5, -10);
  }

  @ParameterizedTest
  @MethodSource("inputProviderValid")
  public void calculatesFactorialCorrectly(int n, int factorial) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not calculate and print the factorial of the entered number correctly.";
    runWithInput(n + "", new Clause[][] { {
        new IntegerLiteral(n),
        new StringLiteral("\\! \\= "),
        new IntegerLiteral(factorial),
    } });
  }

  @ParameterizedTest
  @MethodSource("inputProviderInvalid")
  public void printsErrorMessageForInvalidInput(int n) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print out an error message for invalid input.";
    runWithInput(n + "", new Clause[] {
        new StringLiteral("Invalid Input!"),
    });
  }

}
