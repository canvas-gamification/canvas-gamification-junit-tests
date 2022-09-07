package methods.modular_programs.hard.q5;

import java.util.Objects;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.Logger;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "20 T";
    return new Clause[] {
        new StringLiteral("How fast were you above the speed limit\\?"),
        new NewLine(),
        new StringLiteral("Were you in a school zone\\? \\(Enter T\\/F\\)"),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    DrivingFines.main(new String[0]);
  }

  static Stream<Arguments> inputValidSpeedProvider() {
    return Stream.of(
        Arguments.of(1, 'T', "Your fine is \\$100\\!"),
        Arguments.of(7, 'T', "Your fine is \\$100\\!"),
        Arguments.of(10, 'T', "Your fine is \\$100\\!"),
        Arguments.of(11, 'T', "Your fine is \\$150\\!"),
        Arguments.of(24, 'T', "Your fine is \\$150\\!"),
        Arguments.of(30, 'T', "Your fine is \\$150\\!"),
        Arguments.of(31, 'T', "Your fine is \\$200\\!"),
        Arguments.of(43, 'T', "Your fine is \\$200\\!"),
        Arguments.of(50, 'T', "Your fine is \\$200\\!"),
        Arguments.of(51, 'T', "Your fine is \\$300\\!"),
        Arguments.of(950, 'T', "Your fine is \\$300\\!"),
        Arguments.of(1, 'F', "Your fine is \\$50\\!"),
        Arguments.of(7, 'F', "Your fine is \\$50\\!"),
        Arguments.of(10, 'F', "Your fine is \\$50\\!"),
        Arguments.of(11, 'F', "Your fine is \\$75\\!"),
        Arguments.of(24, 'F', "Your fine is \\$75\\!"),
        Arguments.of(30, 'F', "Your fine is \\$75\\!"),
        Arguments.of(31, 'F', "Your fine is \\$100\\!"),
        Arguments.of(43, 'F', "Your fine is \\$100\\!"),
        Arguments.of(50, 'F', "Your fine is \\$100\\!"),
        Arguments.of(51, 'F', "Your fine is \\$150\\!"),
        Arguments.of(950, 'F', "Your fine is \\$150\\!"));
  }

  static Stream<Arguments> inputInvalidSpeedProvider() {
    return Stream.of(
        Arguments.of(0, 'F'),
        Arguments.of(-1, 'F'),
        Arguments.of(-2, 'F'),
        Arguments.of(-5, 'F'),
        Arguments.of(-10, 'F'),
        Arguments.of(-1000, 'F'),
        Arguments.of(0, 'T'),
        Arguments.of(-1, 'T'),
        Arguments.of(-2, 'T'),
        Arguments.of(-5, 'T'),
        Arguments.of(-10, 'T'),
        Arguments.of(-1000, 'T'),
        Arguments.of(12, 'D'),
        Arguments.of(12, 'P'),
        Arguments.of(12, '0'),
        Arguments.of(12, '?'),
        Arguments.of(0, 'E'));
  }

  @ParameterizedTest
  @MethodSource("inputValidSpeedProvider")
  public void methodGiveValidFine(int speedAbove, char isSchoolZone, String fine) throws Throwable {
    String errMsg = "Your method \"fineCalculator()\" does not return void for the given speed and area.";
    String errMsgOut = "Your method \"fineCalculator()\" does not print the correct fine for the given speed and area.";

    Object output = MethodUtil.invokeIfMethodExists(DrivingFines.class, "fineCalculator",
        new Object[] { speedAbove, isSchoolZone }, int.class, char.class);
    String consoleOutput = MethodUtil.getMethodOutput().trim();

    CustomAssertions._assertTrue(Objects.isNull(output), errMsg, errMsg);
    CustomAssertions._assertEquals(fine.replace("\\", ""), consoleOutput, errMsgOut);
  }

  @ParameterizedTest
  @MethodSource("inputInvalidSpeedProvider")
  public void methodGiveErrorMessage(int speedAbove, char isSchoolZone) throws Throwable {
    String errMsg = "Your method \"fineCalculator()\" does not return the void for invalid inputs.";
    String errMsgOut = "Your method \"fineCalculator()\" does not print the error message for invalid inputs.";

    Object output = MethodUtil.invokeIfMethodExists(DrivingFines.class, "fineCalculator",
        new Object[] { speedAbove, isSchoolZone }, int.class, char.class);
    String consoleOutput = MethodUtil.getMethodOutput().trim();

    CustomAssertions._assertTrue(Objects.isNull(output), errMsg, errMsg);
    CustomAssertions._assertEquals("Invalid Input!", consoleOutput, errMsgOut);
  }

  @ParameterizedTest
  @MethodSource("inputValidSpeedProvider")
  public void printsCorrectOutputValidInput(int speedAbove, char isSchoolZone, String fine)
      throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct fine for the given inputs.";
    runWithInput(speedAbove + " " + isSchoolZone, new Clause[] {
        new StringLiteral(fine),
    });
  }

  @ParameterizedTest
  @MethodSource("inputInvalidSpeedProvider")
  public void printsCorrectOutputInvalidInput(int speedAbove, char isSchoolZone)
      throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct error message for invalid inputs.";
    runWithInput(speedAbove + " " + isSchoolZone, new Clause[] {
        new StringLiteral("Invalid Input!"),
    });
  }
}
