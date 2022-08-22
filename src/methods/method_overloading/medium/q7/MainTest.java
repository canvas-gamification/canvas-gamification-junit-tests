package methods.method_overloading.medium.q7;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.tools.CustomAssertions;
import global.utils.MethodUtil;

public class MainTest {
  // Parsons
  static Stream<Arguments> inputDoubleProvider() {
    return Stream.of(
        Arguments.of(1.0, 1000.0),
        Arguments.of(2.123111, 2123.111),
        Arguments.of(3.14159, 3141.59),
        Arguments.of(0.0, 0.0),
        Arguments.of(-11.12333, -11123.33));
  }

  static Stream<Arguments> inputDoubleIntegerProvider() {
    return Stream.of(
        Arguments.of(1.0, 2, 2.0),
        Arguments.of(2.123111, 3, 6.369333),
        Arguments.of(3.14159, 4, 12.56636),
        Arguments.of(-12.12333, 1000, -12123.33),
        Arguments.of(-1231.12333, 0, 0.0),
        Arguments.of(-12.12333, -1000, 12123.33),
        Arguments.of(0, -1000, 0.0));
  }

  @ParameterizedTest
  @MethodSource("inputDoubleProvider")
  void correctMultiplyDouble(double a, double multiply) throws Throwable {
    String errMsg = "Your method \"multiply()\" does not return the correct value for a double.";
    Object output = MethodUtil.invokeIfMethodExists(OverloadDubDub.class, "multiply", new Object[] { a }, double.class);
    CustomAssertions._assertEquals(output, multiply, 0.0001, errMsg);
  }

  @ParameterizedTest
  @MethodSource("inputDoubleIntegerProvider")
  void correctMultiplyDoubleInteger(double a, int b, double multiply) throws Throwable {
    String errMsg = "Your method \"multiply()\" does not return the correct value for a double and an integer.";
    Object output = MethodUtil.invokeIfMethodExists(OverloadDubDub.class, "multiply", new Object[] { a, b },
        double.class, int.class);
    CustomAssertions._assertEquals(output, multiply, 0.0001, errMsg);
  }
}
