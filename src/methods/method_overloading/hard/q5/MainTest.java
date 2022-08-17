package methods.method_overloading.hard.q5;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    return new Clause[] {
        new StringLiteral("The average of the following numbers is: "),
        new IntegerLiteral("threeInt"),
        new NewLine(),
        new StringLiteral("The average of the following numbers is: "),
        new IntegerLiteral("fourInt"),
        new NewLine(),
        new StringLiteral("The average of the following numbers is: "),
        new IntegerLiteral("fiveInt"),
    };
  }

  public void runMain() {
    Overload5.main(new String[0]);
  }

  static Stream<Arguments> threeNumbersAndTheirAverageProvider() {
    return Stream.of(
        Arguments.of(2, 1, 4, 2),
        Arguments.of(6, 31, 3, 13),
        Arguments.of(76, 122, -123, 25),
        Arguments.of(-2, -2, -1, -1));
  }

  static Stream<Arguments> fourNumbersAndTheirAverageProvider() {
    return Stream.of(
        Arguments.of(2, 2, 4, 4, 3),
        Arguments.of(6, 31, 3, 52, 23),
        Arguments.of(-2, -2, -1, -2, -1));
  }

  static Stream<Arguments> fiveNumbersAndTheirAverageProvider() {
    return Stream.of(
        Arguments.of(5, 0, 1, 2, 3, 2),
        Arguments.of(6, -31, 3, -52, 23, -10),
        Arguments.of(-2, -2, -1, -2, -3, -2));
  }

  @ParameterizedTest
  @MethodSource("threeNumbersAndTheirAverageProvider")
  void threeNumbersAverageCorrect(int a, int b, int c, int avg) throws Throwable {
    String errMsg = "Your method\"average()\" does not correctly calculate the average of three numbers";
    Object output = MethodUtil.invokeIfMethodExists(Overload5.class, "average", new Object[] { a, b, c }, int.class,
        int.class, int.class);
    CustomAssertions._assertEquals(output, avg, errMsg);
  }

  @ParameterizedTest
  @MethodSource("fourNumbersAndTheirAverageProvider")
  void fourNumbersAverageCorrect(int a, int b, int c, int d, int avg) throws Throwable {
    String errMsg = "Your method\"average()\" does not correctly calculate the average of four numbers";
    Object output = MethodUtil.invokeIfMethodExists(Overload5.class, "average", new Object[] { a, b, c, d }, int.class,
        int.class, int.class, int.class);
    CustomAssertions._assertEquals(output, avg, errMsg);
  }

  @ParameterizedTest
  @MethodSource("fiveNumbersAndTheirAverageProvider")
  void fiveNumbersAverageCorrect(int a, int b, int c, int d, int e, int avg) throws Throwable {
    String errMsg = "Your method\"average()\" does not correctly calculate the average of five numbers";
    Object output = MethodUtil.invokeIfMethodExists(Overload5.class, "average", new Object[] { a, b, c, d, e },
        int.class,
        int.class, int.class, int.class, int.class);
    CustomAssertions._assertEquals(output, avg, errMsg);
  }

  @Test
  void printsCorrectMessage() {
    String errMsg = "Your program does not print the correct average for the numbers";
    final int expectedThreeInt = 2;
    final int expectedFourInt = 22;
    final int expectedFiveInt = 202;

    int threeInt = Integer.parseInt(getItemByName("threeInt"));
    int fourInt = Integer.parseInt(getItemByName("fourInt"));
    int fiveInt = Integer.parseInt(getItemByName("fiveInt"));

    CustomAssertions._assertEquals(threeInt, expectedThreeInt, errMsg);
    CustomAssertions._assertEquals(fourInt, expectedFourInt, errMsg);
    CustomAssertions._assertEquals(fiveInt, expectedFiveInt, errMsg);
  }
}