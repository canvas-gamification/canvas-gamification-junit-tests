package methods.method_overloading.medium.q5;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.tools.CustomAssertions;
import global.utils.MethodUtil;

public class MainTest {
  // Parsons
  static Stream<Arguments> inputTwoIntegersProvider() {
    return Stream.of(
        Arguments.of(1, 1, 1),
        Arguments.of(2, 2, 4),
        Arguments.of(3, 3, 9),
        Arguments.of(4, -4, -16),
        Arguments.of(5, 0, 0),
        Arguments.of(0, -23, 0),
        Arguments.of(1236, 231, 285516));
  }

  static Stream<Arguments> inputDoubleAndIntegerProvider() {
    return Stream.of(
        Arguments.of(0.0, -1231, 0.0),
        Arguments.of(1.0, 1, 1.0),
        Arguments.of(-2.31, 2, -4.62),
        Arguments.of(8623.122, 0, 0.0),
        Arguments.of(856.333, 90, 77069.97));
  }

  @ParameterizedTest
  @MethodSource("inputTwoIntegersProvider")
  void correctTwoIntegerProduct(int a, int b, int product) throws Throwable {
    String errMsg = "Your method \"multiply\" does not return the correct product of 2 integers.";
    Object output = MethodUtil.invokeIfMethodExists(OverloadIt.class, "multiply", new Object[] { a, b }, int.class,
        int.class);
    CustomAssertions._assertEquals(output, product, errMsg);
  }

  @ParameterizedTest
  @MethodSource("inputDoubleAndIntegerProvider")
  void correctTwoDoubleProduct(double a, int b, double product) throws Throwable {
    String errMsg = "Your method \"multiply\" does not return the correct product of 2 doubles.";
    Object output = MethodUtil.invokeIfMethodExists(OverloadIt.class, "multiply", new Object[] { a, b }, double.class,
        int.class);
    CustomAssertions._assertEquals(output, product, 0.0001, errMsg);
  }
}
