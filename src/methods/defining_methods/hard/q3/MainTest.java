package methods.defining_methods.hard.q3;

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
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "8";

    return new Clause[]{
      new StringLiteral("Enter the number of sides on the polygon:"),
      new NewLine(),
      new PlaceHolder()
    };
  }

  public void runMain() {
    Polygo.main(new String[0]);
  }

  static Stream<Arguments> innerAnglesInputProvider() {
    return Stream.of(
      Arguments.of(8, 1080),
      Arguments.of(3, 180),
      Arguments.of(100, 17640),
      Arguments.of(10000, 1799640)
    );
  }

  @ParameterizedTest
  @MethodSource("innerAnglesInputProvider")
  void correctInnerAnglesMethod(int a, int innerAngles) throws Throwable {
    String errorMessage = "Your \"innerAngles()\" method does not correctly calculated the inner angles of a polygon with " + a + " sides.";
    Object output = MethodUtil.invokeIfMethodExists(Polygo.class, "innerAngles", new Object[]{a}, int.class);
    CustomAssertions._assertEquals(innerAngles, output, errorMessage);
  }

  @ParameterizedTest
  @MethodSource("innerAnglesInputProvider")
  void printsOutputCorrectly(int a, int innerAngles) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not correctly calculate and print the inner angles of a polygon with " + a + " sides.";
    runWithInput(a + "", new Clause[][]{{
      new StringLiteral("The sum of interior angles of the polygon is\\: "),
      new IntegerLiteral(innerAngles)
    }});
  }

}
