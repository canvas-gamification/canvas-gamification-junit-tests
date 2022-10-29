package methods.defining_methods.hard.q6;

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
    TestOption.defaultInput = "5";

    return new Clause[] {
        new StringLiteral("Enter a number:"),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    IntegerMulter.main(new String[0]);
  }

  static Stream<Arguments> numberBetween0And10() {
    return Stream.of(
        Arguments.of(0, 0),
        Arguments.of(1, 1000),
        Arguments.of(2, 2000),
        Arguments.of(3, 3000),
        Arguments.of(4, 4000),
        Arguments.of(5, 5000),
        Arguments.of(6, 6000),
        Arguments.of(7, 7000),
        Arguments.of(8, 8000),
        Arguments.of(9, 9000),
        Arguments.of(10, 10000));
  }

  @ParameterizedTest
  @MethodSource("numberBetween0And10")
  void correctMultiply1000Method(int num, int newNum) throws Throwable {
    String errorMessage = "Your method multiply1000() does not return the correct number.";
    Object output = MethodUtil.invokeIfMethodExists(IntegerMulter.class, "multiply1000", new Object[] { num },
        int.class);
    CustomAssertions._assertEquals(output, newNum, errorMessage);
  }

  @ParameterizedTest
  @MethodSource("numberBetween0And10")
  void printsCorrectMessage(int num, int newNum) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message for the number.";
    runWithInput(num + "", new Clause[][] { {
        new StringLiteral("The new number is: "),
        new IntegerLiteral(newNum),
    } });
  }
}
