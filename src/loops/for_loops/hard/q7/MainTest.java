package loops.for_loops.hard.q7;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Parsons
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "Hello World";
    return new Clause[] {
        new StringLiteral("Enter a sentence\\: "),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    RevUp.main(new String[0]);
  }

  static Stream<Arguments> inputProvider() {
    return Stream.of(
        Arguments.of("Hello World", "dlroW olleH"),
        Arguments.of("a", "a"),
        Arguments.of("1", "1"),
        Arguments.of("123?123", "321\\?321"),
        Arguments.of("Hello 123?123 ONE two ThReE !@+'", "\\'\\+\\@\\! EeRhT owt ENO 321\\?321 olleH"));
  }

  @ParameterizedTest
  @MethodSource("inputProvider")
  public void printsReversedSentence(String input, String reversed) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct reversed sentence for the given sentence.";
    runWithInput(input, new Clause[] {
        new StringLiteral("Reversed Sentence: " + reversed)
    });
  }
}
