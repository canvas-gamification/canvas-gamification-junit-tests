package methods.defining_methods.hard.q7;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "366";

    return new Clause[] {
        new StringLiteral("Enter the number of days in this year:"),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    CurrentYearMethod.main(new String[0]);
  }

  static Stream<Arguments> possibleNumDaysForMethod() {
    return Stream.of(
        Arguments.of(366, true),
        Arguments.of(365, false));
  }

  static Stream<Arguments> possibleNumDaysForOutput() {
    return Stream.of(
        Arguments.of(366, "This year is a leap year"),
        Arguments.of(365, "This year isn't a leap year"));
  }

  @ParameterizedTest
  @MethodSource("possibleNumDaysForMethod")
  void correctLeapCheckerMethod(int numDays, boolean isLeapYear) throws Throwable {
    String errorMessage = "Your method \"leapChecker()\" does not return the correct result";
    Object output = MethodUtil.invokeIfMethodExists(CurrentYearMethod.class, "leapChecker", new Object[] { numDays },
        int.class);
    CustomAssertions._assertEquals(output, isLeapYear, errorMessage);
  }

  @ParameterizedTest
  @MethodSource("possibleNumDaysForOutput")
  void printsCorrectLeapYearMessage(int numDays, String isLeapYearStr) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message for this year";
    runWithInput(numDays + "", new Clause[] {
        new StringLiteral(isLeapYearStr),
    });
  }
}
