package loops.for_loops.hard.q8;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Parsons
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "Hello World!";
    return new Clause[] {
        new StringLiteral("Enter a sentence"),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    CounterChar.main(new String[0]);
  }

  static Stream<Arguments> inputProvider() {
    return Stream.of(
        Arguments.of("Hello World!", 11),
        Arguments.of("      Hi", 2),
        Arguments.of("123   Hi", 5),
        Arguments.of("! @ # $ % ^ & * ( ) ", 10));
  }

  @ParameterizedTest
  @MethodSource("inputProvider")
  public void printsCorrectNumberOfCharacters(String sentence, int numChar) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct number of characters in the given sentence.";
    runWithInput(sentence, new Clause[][] { {
        new StringLiteral("Total number of Characters in the sentence: "),
        new IntegerLiteral(numChar),
    } });
  }
}
