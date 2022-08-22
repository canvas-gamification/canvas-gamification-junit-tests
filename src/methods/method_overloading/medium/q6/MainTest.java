package methods.method_overloading.medium.q6;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.tools.CustomAssertions;
import global.utils.MethodUtil;

public class MainTest {
  // Parsons
  static Stream<Arguments> inputDoubleFloatProvider() {
    return Stream.of(
        Arguments.of(1.0, 2.0, 0.5),
        Arguments.of(2.0, 1.0, 2.0),
        Arguments.of(1.0, 1.0, 1.0),
        Arguments.of(0.0, 1.0, 0.0),
        Arguments.of(2.55, 222.123, 0.01148),
        Arguments.of(222.123, -2.55, -87.1071));
  }

  static Stream<Arguments> inputIntLongProvider() {
    return Stream.of(
        Arguments.of(1, 2, 0.0),
        Arguments.of(2, 1, 2.0),
        Arguments.of(1, 1, 1.0),
        Arguments.of(0, 1, 0.0),
        Arguments.of(2, 222, 0.0),
        Arguments.of(222, -2, -111.0));
  }

  @ParameterizedTest
  @MethodSource("inputDoubleFloatProvider")
  void correctDoubleFloatDivide(double a, double b, double divide) throws Throwable {
    String errMsg = "Your method \"divide()\" does not return a correct value for double and float.";
    float floatB = (float) b;
    Object output = MethodUtil.invokeIfMethodExists(OverloadFloat.class, "divide",
        new Object[] { a, floatB }, double.class, float.class);
    CustomAssertions._assertEquals(output, divide, 0.0001, errMsg);
  }

  @ParameterizedTest
  @MethodSource("inputIntLongProvider")
  void correctIntLongDivide(int a, long b, double divide) throws Throwable {
    String errMsg = "Your method \"divide()\" does not return a correct value for int and long.";
    Object output = MethodUtil.invokeIfMethodExists(OverloadFloat.class, "divide", new Object[] { a, b }, int.class,
        long.class);
    CustomAssertions._assertEquals(output, divide, 0.0001, errMsg);
  }
}
