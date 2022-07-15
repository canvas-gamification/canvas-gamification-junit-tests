package loops.programs_with_repetition.easy.q4;

import java.util.ArrayList;
import java.util.Iterator;
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
  // Java
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "2";
    return new Clause[] {
        new StringLiteral("Enter an integer\\: "),
        new NewLine(),
        new PlaceHolder(),
    };
  }

  public void runMain() {
    ItsAlwaysPrimeTime.main(new String[0]);
  }

  static Stream<Arguments> allPrimeInputs() {
    int[] allPrimesUnder50 = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };
    Stream<Arguments> allPrimeInputs = Stream.of();
    for (int primeNumber : allPrimesUnder50) {
      allPrimeInputs = Stream.concat(allPrimeInputs, Stream.of(Arguments.of(primeNumber)));
    }
    return allPrimeInputs;
  }

  static Stream<Arguments> repetitiveInputs() {
    int[] allPrimesUnder50 = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };
    int[] allCompositesUnder50AndNegatives = { 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28,
        30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12 };
    Stream<Arguments> allPrimeInputs = Stream.of();
    for (int primeNumber : allPrimesUnder50) {
      int numberOfWrongs = (int) (Math.random() * 20) + 1;
      ArrayList<Integer> inputs = new ArrayList<>();
      for (int i = 0; i < numberOfWrongs; i++) {
        inputs.add(allCompositesUnder50AndNegatives[(int) (Math.random() * allCompositesUnder50AndNegatives.length)]);
      }
      inputs.add(primeNumber);

      allPrimeInputs = Stream.concat(allPrimeInputs, Stream.of(Arguments.of(inputs)));
    }
    return allPrimeInputs;
  }

  @ParameterizedTest
  @MethodSource("allPrimeInputs")
  public void printsCorrectMessageWithOneInput(int input) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not stop when it enters a prime number that is less than 50.";
    runWithInput(String.valueOf(input), new Clause[] {
        new StringLiteral("Entered a prime number that is less than 50. Ending Program. "),
    });
  }

  @ParameterizedTest
  @MethodSource("repetitiveInputs")
  public void printsCorrectMessageWithMultipleInputs(ArrayList<Integer> inputs) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not stop when it enters a prime number that is less than 50.";
    Iterator<Integer> it = inputs.iterator();
    Clause[][] outputStrings = new Clause[1][inputs.size() * 3 - 2];
    for (int i = 0; i < inputs.size() * 3 - 3; i += 3) {
      outputStrings[0][i + 0] = new IntegerLiteral(it.next());
      outputStrings[0][i + 1] = new StringLiteral("Enter an integer\\: ");
      outputStrings[0][i + 2] = new NewLine();
    }
    outputStrings[0][inputs.size() * 3 - 3] = new StringLiteral(
        "Entered a prime number that is less than 50. Ending Program. ");
  }
}
