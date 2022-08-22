package methods.method_overloading.medium.q8;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.tools.CustomAssertions;
import global.utils.MethodUtil;

public class MainTest {
  // Parsons
  static Stream<Arguments> inputTwoCharsProvider() {
    return Stream.of(
        Arguments.of('a', 'b', 'b'),
        Arguments.of('(', 'a', 'a'),
        Arguments.of('(', '?', '?'),
        Arguments.of('0', '1', '1'),
        Arguments.of('Z', 'a', 'a'),
        Arguments.of('Z', '0', 'Z'),
        Arguments.of('z', 'a', 'z'));
  }

  static Stream<Arguments> inputThreeIntsProvider() {
    return Stream.of(
        Arguments.of(1, 2, 3, 3),
        Arguments.of(23, 22, -123, 23),
        Arguments.of(0, 0, 0, 0),
        Arguments.of(0, 1, 2, 2),
        Arguments.of(0, -1, -2, 0),
        Arguments.of(-1, -2, -3, -1));
  }

  @ParameterizedTest
  @MethodSource("inputTwoCharsProvider")
  void correctTwoCharGreater(char a, char b, char greater) throws Throwable {
    String errMsg = "Your method \"greatest()\" does not print the greater character.";
    Object output = MethodUtil.invokeIfMethodExists(OverloadChar.class, "greatest", new Object[] { a, b }, char.class,
        char.class);
    CustomAssertions._assertEquals(output, greater, errMsg);
  }

  @ParameterizedTest
  @MethodSource("inputThreeIntsProvider")
  void correctThreeIntsGreatest(int a, int b, int c, int greatest) throws Throwable {
    String errMsg = "Your method \"greatest()\" does not print the greatest character.";
    Object output = MethodUtil.invokeIfMethodExists(OverloadChar.class, "greatest", new Object[] { a, b, c },
        int.class,
        int.class, int.class);
    CustomAssertions._assertEquals(output, greatest, errMsg);
  }
}
