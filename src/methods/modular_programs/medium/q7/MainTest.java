package methods.modular_programs.medium.q7;

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
    TestOption.defaultInput = "6";
    return new Clause[] {
        new StringLiteral("Enter a number: "),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    NowThatsPerfect.main(new String[0]);
  }

  static Stream<Integer> perfectNumberProvider() {
    return Stream.of(6, 28, 496, 8128, 33550336);
  }

  static Stream<Integer> imperfectNumberProvider() {
    return Stream.of(1, 2, -1, 27, 11, 9092);
  }

  @ParameterizedTest
  @MethodSource("perfectNumberProvider")
  public void correctsPerfectNumberMethod(int n) throws Throwable {
    String errMsg = "Your method \"perfectOrNot()\" does not return the correct result for perfect numbers.";
    Object output = MethodUtil.invokeIfMethodExists(NowThatsPerfect.class, "perfectOrNot", new Object[] { n },
        int.class);
    CustomAssertions._assertEquals(output, true, errMsg);
  }

  @ParameterizedTest
  @MethodSource("imperfectNumberProvider")
  public void correctsImperfectNumberMethod(int n) throws Throwable {
    String errMsg = "Your method \"perfectOrNot()\" does not return the correct result for imperfect numbers.";
    Object output = MethodUtil.invokeIfMethodExists(NowThatsPerfect.class, "perfectOrNot", new Object[] { n },
        int.class);
    CustomAssertions._assertEquals(output, false, errMsg);
  }

  @ParameterizedTest
  @MethodSource("perfectNumberProvider")
  public void printsPerfectNumberCorrects(int n) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message for perfect number.";
    runWithInput(n + "", new Clause[] {
        new StringLiteral("perfect"),
    });
  }

  @ParameterizedTest
  @MethodSource("imperfectNumberProvider")
  public void printsImperfectNumberCorrects(int n) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message for imperfect number.";
    runWithInput(n + "", new Clause[] {
        new StringLiteral("imperfect"),
    });
  }
}
