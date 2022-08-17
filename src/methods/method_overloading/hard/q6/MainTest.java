package methods.method_overloading.hard.q6;

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
  // Java
  public Clause[] testSentence() {
    return new Clause[] {
        new StringLiteral("The following student has a valid username: true"),
        new NewLine(),
        new StringLiteral("The following student has a valid student number: true"),
        new NewLine(),
        new StringLiteral("The following student does not have a valid username: false"),
        new NewLine(),
        new StringLiteral("The following student does not have a valid student number: false"),
    };
  }

  public void runMain() {
    Overload6.main(new String[0]);
  }

  static Stream<Integer> validStudentNumberProvider() {
    return Stream.of(12345678, 51927731, 981237091, 10000000);
  }

  static Stream<Integer> invalidStudentNumberProvider() {
    return Stream.of(0, -1, 100, 999, 6484831, 9999999, 00000001);
  }

  static Stream<Arguments> validStudentNameProvider() {
    return Stream.of(
        Arguments.of("John", "Smith", "John.Smith"),
        Arguments.of("Jack", "Swift", "Jack.Swift"),
        Arguments.of("Ben", "Doe", "Ben.Doe"),
        Arguments.of("123", "456", "123.456"),
        Arguments.of("Hello", "World", "Hello.World"),
        Arguments.of(" ", " ", " . "));
  }

  static Stream<Arguments> invalidStudentNameProvider() {
    return Stream.of(
        Arguments.of(" ", "123", " .12"),
        Arguments.of("Jack", "Swift", "jackSwift151"),
        Arguments.of("Hello", "World", "Hello.World!"),
        Arguments.of("Hello", "World", "Hello World"),
        Arguments.of("Hello", "World", "HelloWorld"));
  }

  @ParameterizedTest
  @MethodSource("validStudentNumberProvider")
  public void StudentNumberCorrects(int studentID) throws Throwable {
    String errMsg = "Your method \"studentCheck()\" does not determine the correct student for given student id.";
    Object output = MethodUtil.invokeIfMethodExists(Overload6.class, "studentCheck", new Object[] { studentID },
        int.class);
    CustomAssertions._assertEquals(output, true, errMsg);
  }

  @ParameterizedTest
  @MethodSource("invalidStudentNumberProvider")
  public void StudentNumberIncorrects(int studentID) throws Throwable {
    String errMsg = "Your method \"studentCheck()\" does not determine the correct student for given student id.";
    Object output = MethodUtil.invokeIfMethodExists(Overload6.class, "studentCheck", new Object[] { studentID },
        int.class);
    CustomAssertions._assertEquals(output, false, errMsg);
  }

  @ParameterizedTest
  @MethodSource("validStudentNameProvider")
  public void StudentNameCorrects(String fname, String lname, String username) throws Throwable {
    String errMsg = "Your method \"studentCheck()\" does not determine the correct student for given student name.";
    Object output = MethodUtil.invokeIfMethodExists(Overload6.class, "studentCheck",
        new Object[] { fname, lname, username },
        String.class, String.class, String.class);
    CustomAssertions._assertEquals(output, true, errMsg);
  }

  @ParameterizedTest
  @MethodSource("invalidStudentNameProvider")
  public void StudentNameIncorrects(String fname, String lname, String username) throws Throwable {
    String errMsg = "Your method \"studentCheck()\" does not determine the correct student for given student name.";
    Object output = MethodUtil.invokeIfMethodExists(Overload6.class, "studentCheck",
        new Object[] { fname, lname, username },
        String.class, String.class, String.class);
    CustomAssertions._assertEquals(output, false, errMsg);
  }
}
