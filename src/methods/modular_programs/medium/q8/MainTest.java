package methods.modular_programs.medium.q8;

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
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = " Hello There ";
    return new Clause[] {
        new StringLiteral("Enter a sentence: "),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    QueryStr.main(new String[0]);
  }

  static Stream<Arguments> inputSentenceProvider() {
    return Stream.of(
        Arguments.of(" Hello There ", "%20%Hello%20%There%20%"),
        Arguments.of(" ", "%20%"),
        Arguments.of("Hello", "Hello"),
        Arguments.of("Hello There", "Hello%20%There"));
  }

  @ParameterizedTest
  @MethodSource("inputSentenceProvider")
  void methodCleanUpCorrect(String originalStr, String cleanedUpStr) throws Throwable {
    String errMsg = "Your method \"cleanUp()\" does not return the correct cleaned up string.";
    Object output = MethodUtil.invokeIfMethodExists(QueryStr.class, "cleanUp", new Object[] { originalStr },
        String.class);
    CustomAssertions._assertEquals(output, cleanedUpStr, errMsg);
  }

  @ParameterizedTest
  @MethodSource("inputSentenceProvider")
  void printsCorrectOutput(String originalStr, String cleanedUpStr) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct cleanup up string for the given string.";
    runWithInput(originalStr, new Clause[][] { {
        new StringLiteral("The new query string is: "),
        new StringLiteral(cleanedUpStr),
    } });
  }
}
