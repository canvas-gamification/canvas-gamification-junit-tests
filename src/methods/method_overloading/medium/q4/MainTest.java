package methods.method_overloading.medium.q4;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.tools.CustomAssertions;
import global.utils.MethodUtil;

public class MainTest {
  // Parsons
  static Stream<Arguments> inputThreeIntegersProvider() {
    return Stream.of(
        Arguments.of(1, 2, 3, 2.0),
        Arguments.of(1, 0, 2, 1.0),
        Arguments.of(0, 1, 2, 1.0),
        Arguments.of(-2, 0, 2, 0.0),
        Arguments.of(0, -2, 2, 0.0),
        Arguments.of(1002, 2124, 963, 1363.0));
  }

  static Stream<Arguments> inputThreeDoublesProvider() {
    return Stream.of(
        Arguments.of(1.2, 2.123, 222.0, 75.1077),
        Arguments.of(1.122, -1231.6, 51.22, -393.086),
        Arguments.of(0.0, 0.0, 0.0, 0.0),
        Arguments.of(1.0, 2.0, 3.0, 2.0),
        Arguments.of(1.0, 0.0, 2.0, 1.0));
  }

  @ParameterizedTest
  @MethodSource("inputThreeIntegersProvider")
  void correctsThreeIntegersAverage(int a, int b, int c, double avg) throws Throwable {
    String errMsg = "Your method \"average()\" does not return the correct average for three integers";
    Object output = MethodUtil.invokeIfMethodExists(AveOfThree.class, "average", new Object[] { a, b, c },
        int.class, int.class, int.class);
    CustomAssertions._assertEquals(output, avg, 0.0001, errMsg);
  }

  @ParameterizedTest
  @MethodSource("inputThreeDoublesProvider")
  void correctsThreeDoublesAverage(double a, double b, double c, double avg) throws Throwable {
    String errMsg = "Your method \"average()\" does not return the correct average for three doubles";
    Object output = MethodUtil.invokeIfMethodExists(AveOfThree.class, "average", new Object[] { a, b, c },
        double.class, double.class, double.class);
    CustomAssertions._assertEquals(output, avg, 0.0001, errMsg);
  }
}
