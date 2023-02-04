package methods.modular_programs.hard.q5;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
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
            new StringLiteral("How far above the speed limit were you\\?"),
            new Optional(new StringLiteral(" ")),
            new NewLine(),
            new StringLiteral("Were you in a school zone\\? \\(Enter T\\/F\\)"),
            new Optional(new StringLiteral(" ")),
            new NewLine(),
            new StringLiteral("Your fine is "),
            new IntegerLiteral("ans"),
            new StringLiteral(" dollars!"),
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
            Arguments.of(20, 'T', findFor(20, 'T')),
            Arguments.of(v1, 'T', findFor(v1, 'T')),
            Arguments.of(v2, 'T', findFor(v2, 'T')),
            Arguments.of(v3, 'T', findFor(v3, 'T')),
            Arguments.of(v1 + 1, 'T', findFor(v1 + 1, 'T')),
            Arguments.of(v2 + 1, 'T', findFor(v2 + 1, 'T')),
            Arguments.of(v3 + 1, 'T', findFor(v3 + 1, 'T')),
            Arguments.of(v1 - 1, 'T', findFor(v1 - 1, 'T')),
            Arguments.of(v2 - 1, 'T', findFor(v2 - 1, 'T')),
            Arguments.of(v3 - 1, 'T', findFor(v3 - 1, 'T')),
            Arguments.of(0, 'T', findFor(0, 'T')),
            Arguments.of(-1, 'T', findFor(0, 'T')),
            Arguments.of(20, 'F', findFor(20, 'F')),
            Arguments.of(v1, 'F', findFor(v1, 'F')),
            Arguments.of(v2, 'F', findFor(v2, 'F')),
            Arguments.of(v3, 'F', findFor(v3, 'F')),
            Arguments.of(v1 + 1, 'F', findFor(v1 + 1, 'F')),
            Arguments.of(v2 + 1, 'F', findFor(v2 + 1, 'F')),
            Arguments.of(v3 + 1, 'F', findFor(v3 + 1, 'F')),
            Arguments.of(v1 - 1, 'F', findFor(v1 - 1, 'F')),
            Arguments.of(v2 - 1, 'F', findFor(v2 - 1, 'F')),
            Arguments.of(v3 - 1, 'F', findFor(v3 - 1, 'F')),
            Arguments.of(0, 'F', findFor(0, 'F')),
            Arguments.of(-1, 'F', findFor(0, 'F'))
    );
  }

  @ParameterizedTest
  @MethodSource("inputProvider")
  public void printsCorrectOutput(int speed, char isSchoolZone, int fine) throws InvalidClauseException {
    runWithInput(speed + " " + isSchoolZone);
    CustomAssertions._assertEquals(fine, Integer.parseInt(getItemByName("ans")), "Your program does not correctly print the cost of the fine.");
  }

  @ParameterizedTest
  @MethodSource("inputProvider")
  public void correctFineCalculatorMethod(int speed, char isSchoolZone, int fine) throws Throwable {
    TestOption.incorrectStructureErrorMessage = "Your fineCalculator method does not correctly print the fine.";
    Clause[] methodSentence;
    methodSentence = new Clause[]{
            new StringLiteral("Your fine is " + fine + " dollars!"),
    };
    Object[][] arguments = {
            {speed, int.class},
            {isSchoolZone, char.class}
    };
    MethodTest m = new MethodTest(DrivingFines.class, "fineCalculator", arguments, methodSentence);
    m.callMethod();
  }
}
