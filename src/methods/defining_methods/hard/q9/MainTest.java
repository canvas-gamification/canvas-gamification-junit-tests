package methods.defining_methods.hard.q9;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "3";
    return new Clause[] {
        new StringLiteral("Enter the number of courses you're taking this year:"),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    NumCoursesMethod.main(new String[0]);
  }

  static Stream<Arguments> coursesInputProvider() {
    return Stream.of(
        Arguments.of(3, 9),
        Arguments.of(4, 12),
        Arguments.of(50, 150),
        Arguments.of(0, 0),
        Arguments.of(10000, 30000),
            Arguments.of(-1, -1),
            Arguments.of(-2, -1),
            Arguments.of(-404, -1)
    );
  }

  @ParameterizedTest
  @MethodSource("coursesInputProvider")
  void methodCreditsCalcCorrect(int courses, int credits) throws Throwable {
    Object[][] arguments = {
            {courses, int.class}
    };
    MethodTest m = new MethodTest(NumCoursesMethod.class, "creditsCalc", arguments);
    Object output = m.callMethod();
    String errorMsg = "Your creditsCalc() method does not correctly calculate the number of credits.";
    CustomAssertions._assertEquals(credits, output, errorMsg);
  }

  @ParameterizedTest
  @MethodSource("coursesInputProvider")
  void printsCorrectMessage(int courses, int credits) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct credit message.";
    runWithInput(courses + "", new Clause[][] { {
        new StringLiteral("The number of credits you'll receive is "),
        new IntegerLiteral(credits),
    } });
  }
}
