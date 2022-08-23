package methods.modular_programs.hard.q3;

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
    TestOption.defaultInput = "2";
    return new Clause[] {
        new StringLiteral("Which year are you in\\? \\(1, 2 ,3, or 4\\)"),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    UniversityLife.main(new String[0]);
  }

  static Stream<Arguments> inputValidYearProvider() {
    return Stream.of(
        Arguments.of(1, "You're a Freshman"),
        Arguments.of(2, "You're a Sophomore"),
        Arguments.of(3, "You're a Junior"),
        Arguments.of(4, "You're a Senior"));
  }

  static Stream<Integer> inputInvalidYearProvider() {
    return Stream.of(-1, 0, 5, 100);
  }

  @ParameterizedTest
  @MethodSource("inputValidYearProvider")
  void methodValidYearCorrect(int year, String title) throws Throwable {
    String errMsg = "Your method \"universityYear\" does not return the correct title for the given year.";
    Object output = MethodUtil.invokeIfMethodExists(UniversityLife.class, "universityYear", new Object[] { year },
        int.class);
    CustomAssertions._assertEquals(output, title, errMsg);
  }

  @ParameterizedTest
  @MethodSource("inputInvalidYearProvider")
  void methodInvalidYearException(int year) throws Throwable {
    String errMsg = "Your method \"universityYear\" does not throw an exception for the given year.";
    Object output = MethodUtil.invokeIfMethodExists(UniversityLife.class, "universityYear", new Object[] { year },
        int.class);
    CustomAssertions._assertEquals(output, "Invalid Input!", errMsg);
  }

  @ParameterizedTest
  @MethodSource("inputValidYearProvider")
  void printsCorrectOutputValidYear(int year, String title) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct output for the given year.";
    runWithInput(year + "", new Clause[] {
        new StringLiteral(title),
    });
  }

  @ParameterizedTest
  @MethodSource("inputInvalidYearProvider")
  void printsCorrectOutputInvalidYear(int year) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct output for the given year.";
    runWithInput(year + "", new Clause[] {
        new StringLiteral("Invalid Input!"),
    });
  }
}
