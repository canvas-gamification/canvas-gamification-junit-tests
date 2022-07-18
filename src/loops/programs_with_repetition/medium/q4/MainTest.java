package loops.programs_with_repetition.medium.q4;

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
  // Java
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "5";
    return new Clause[] {
        new StringLiteral("How wide is your hourglass\\?"),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    OurGlass.main(new String[0]);
  }

  static Stream<Arguments> inputProviderValid() {
    return Stream.of(
        Arguments.of(10, hourGlassPatternClause(10)),
        Arguments.of(5, hourGlassPatternClause(5)),
        Arguments.of(1, new Clause[][] { { new StringLiteral("\\* "), new NewLine() } }));
  }

  static Stream<Integer> inputProviderInvalid() {
    return Stream.of(0, -1, -5, -10);
  }

  @ParameterizedTest
  @MethodSource("inputProviderValid")
  public void printsCorrectHourglass(int width, Clause[][] hourglass) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print a correct hourglass with the given width.";
    runWithInput(width + "", hourglass);
  }

  @ParameterizedTest
  @MethodSource("inputProviderInvalid")
  public void printsErrorMessageForInvalidInput(int width) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print an error message when the width is invalid";
    runWithInput(width + "", new Clause[] { new StringLiteral("Invalid Input!") });
  }

  static Clause[][] hourGlassPatternClause(int n) {
    Clause[][] c = new Clause[1][n * 4 - 2];
    int index = 0;
    for (int i = n; i >= 1; --i) {
      StringBuilder sb = new StringBuilder();
      sb.append(" ".repeat(n - i));
      sb.append("\\* ".repeat(i));
      c[0][index++] = new StringLiteral(sb.toString());
      c[0][index++] = new NewLine();
    }
    for (int i = 2; i <= n; ++i) {
      StringBuilder sb = new StringBuilder();
      sb.append(" ".repeat(n - i));
      sb.append("\\* ".repeat(i));
      c[0][index++] = new StringLiteral(sb.toString());
      c[0][index++] = new NewLine();
    }

    return c;
  }
}
