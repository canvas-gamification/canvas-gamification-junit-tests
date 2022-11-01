package methods.method_overloading.medium.q3;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  public Clause[] testSentence() {
    return new Clause[] {
        new StringLiteral("Hello I am "),
        new NewLine(),
        new StringLiteral("Hello I am bob")
    };
  }

  public void runMain() {
    ThreeStrings.main(new String[0]);
  }

  static Stream<Arguments> inputTwoStringsProvider() {
    return Stream.of(
        Arguments.of("Hello", " I am ", "Hello I am "),
        Arguments.of("Hello", " the world is ending", "Hello the world is ending"),
        Arguments.of("Hello ", "World!", "Hello World!"),
        Arguments.of(" ", " ", "  "),
        Arguments.of("", "", ""));
  }

  static Stream<Arguments> inputThreeStringsProvider() {
    return Stream.of(
        Arguments.of("Hello", " I am ", "bob", "Hello I am bob"),
        Arguments.of("Hello", " I am", "", "Hello I am"),
        Arguments.of("Goodbye", "", "Seth", "GoodbyeSeth"),
        Arguments.of("I am", " ", "rob", "I am rob"),
        Arguments.of("", "I am", " bob", "I am bob"),
        Arguments.of("", "", "", ""),
        Arguments.of(" ", " ", " ", "   "));
  }

  @ParameterizedTest
  @MethodSource("inputTwoStringsProvider")
  void correctTwoStringMethod(String s1, String s2, String output) throws Throwable {
    Object outputObject = MethodUtil.invokeIfMethodExists(ThreeStrings.class, "concatenate", new Object[] { s1, s2 },
        String.class, String.class);
    CustomAssertions._assertEquals(output, outputObject,
        "Your concatenate method does not correctly concatenate two strings.");
  }

  @ParameterizedTest
  @MethodSource("inputThreeStringsProvider")
  void correctThreeStringMethod(String s1, String s2, String s3, String output) throws Throwable {
    Object outputObject = MethodUtil.invokeIfMethodExists(ThreeStrings.class, "concatenate", new Object[] { s1, s2, s3 },
        String.class, String.class, String.class);
    CustomAssertions._assertEquals(output, outputObject,
        "Your concatenate method does not correctly concatenate three strings.");
  }
}
