package methods.modular_programs.hard.q5;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
  // Java

  public static final int v1 = 10;
  public static final int v2 = 30;
  public static final int v3 = 50;
  public static final int p1 = 50;
  public static final int p2 = 75;
  public static final int p3 = 100;
  public static final int p4 = 150;

  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "20 T";
    return new Clause[]{
            new StringLiteral("How fast were you above the speed limit\\?"),
            new Optional(new StringLiteral(" ")),
            new NewLine(),
            new StringLiteral("Were you in a school zone\\? \\(Enter T\\/F\\)"),
            new Optional(new StringLiteral(" ")),
            new NewLine(),
            new PlaceHolder(),
            new Optional(new StringLiteral(" ")),
    };
  }

  public void runMain() {
    DrivingFines.main(new String[0]);
  }

  public static int findFor(int v, char c) {
    int ans;
    if (v > v3)
      ans = p4;
    else if (v > v2 && v <= v3)
      ans = p3;
    else if (v > v1 && v <= v2)
      ans = p2;
    else if (v > 0 && v <= v1)
      ans = p1;
    else
      ans = 0;
    if (c == 'T')
      ans *= 2;
    return ans;

  }

  static Stream<Arguments> inputProvider() {
    return Stream.of(
            Arguments.of("20", 'T', findFor(20, 'T')),
            Arguments.of(Integer.toString(v1), 'T', findFor(v1, 'T')),
            Arguments.of(Integer.toString(v2), 'T', findFor(v2, 'T')),
            Arguments.of(Integer.toString(v3), 'T', findFor(v3, 'T')),
            Arguments.of(Integer.toString(v1 + 1), 'T', findFor(v1 + 1, 'T')),
            Arguments.of(Integer.toString(v2 + 1), 'T', findFor(v2 + 1, 'T')),
            Arguments.of(Integer.toString(v3 + 1), 'T', findFor(v3 + 1, 'T')),
            Arguments.of(Integer.toString(v1 - 1), 'T', findFor(v1 - 1, 'T')),
            Arguments.of(Integer.toString(v2 - 1), 'T', findFor(v2 - 1, 'T')),
            Arguments.of(Integer.toString(v3 - 1), 'T', findFor(v3 - 1, 'T')),
            Arguments.of("0", 'T', findFor(0, 'T')),
            Arguments.of("-1", 'T', findFor(0, 'T')),
            Arguments.of("False Number Format", 'T', -1),
            Arguments.of("10", 'R', -1),
            Arguments.of("False Number Format", 'E', -1)
    );
  }

  @ParameterizedTest
  @MethodSource("inputProvider")
  public void printsCorrectOutput(String speedst, char isSchoolZone, int fine) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct amount of fine or the correct answer.";
    if (fine != -1) {
      runWithInput(speedst + " " + isSchoolZone, new Clause[]{
              new StringLiteral("Your fine is " + fine + " dollars!")
      });
    } else {
      runWithInput(speedst + " " + isSchoolZone, new Clause[]{
              new StringLiteral("Invalid Input!")
      });
    }
  }

  @ParameterizedTest
  @MethodSource("inputProvider")
  public void correctFineCalculatorMethod(String speedst, char isSchoolZone, int fine) throws Throwable {
    TestOption.incorrectStructureErrorMessage = "Your fineCalculator method does not print the correct fine or answer.";
    Clause[] methodSentence;
    if (fine != -1) {
      methodSentence = new Clause[]{
              new StringLiteral("Your fine is " + fine + " dollars!"),
      };
    } else {
      methodSentence = new Clause[]{
              new StringLiteral("Invalid Input!"),
      };
    }
    Object[][] arguments = {
            {speedst, String.class},
            {isSchoolZone, char.class}
    };
    MethodTest m = new MethodTest(DrivingFines.class, "fineCalculator", arguments, methodSentence);
    m.callMethod();
  }
}

