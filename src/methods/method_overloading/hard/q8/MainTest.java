package methods.method_overloading.hard.q8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java

  public Clause[] testSentence() {
    return new Clause[] {
        new StringLiteral("The data type associated with 14 is: "),
        new StringLiteral("int"),
        new NewLine(),
        new StringLiteral("The data type associated with 61.34 is: "),
        new StringLiteral("double"),
    };
  }

  public void runMain() {
    FindDataType.main(new String[0]);
  }

  static Stream<Integer> inputIntegerProvider() {
    return Stream.of(-1000, -5, -1, 0, 1, 7, 121, 4444);
  }

  static Stream<Double> inputDoubleProvider() {
    return Stream.of(-1000.11, -5.123, -1.0, 0.7, 1.0001, 7.8989, 121.1, 4444.4444444);
  }

  @ParameterizedTest
  @MethodSource("inputIntegerProvider")
  void correctPrintTypeIntegerMethod(int intNumber) throws Throwable {
    Object[][] arguments = {
            {intNumber, int.class}
    };
    MethodTest m = new MethodTest(FindDataType.class, "printType", arguments);
    Object output = m.callMethod();
    String errorMessage = "Your printType() method for integer does not print the correct type.";
    CustomAssertions._assertEquals("int", output, errorMessage);
  }

  @ParameterizedTest
  @MethodSource("inputDoubleProvider")
  void correctPrintTypeDoubleMethod(double doubleNumber) throws Throwable {
    Object[][] arguments = {
            {doubleNumber, double.class}
    };
    MethodTest m = new MethodTest(FindDataType.class, "printType", arguments);
    Object output = m.callMethod();
    String errorMessage = "Your printType() method for double does not print the correct type.";
    CustomAssertions._assertEquals(output, "double", errorMessage);
  }
}
