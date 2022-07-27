package loops.programs_with_repetition.easy.q5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.Logger;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "777";
    return new Clause[] {
        new StringLiteral("Enter an integer\\: "),
        new NewLine(),
        new PlaceHolder()
    };
  }

  public void runMain() {
    MirrorSeven.main(new String[0]);
  }

  static Stream<Integer> inputProviderValidOneInput() {
    return Stream.of(0, 7, 77, 161, 343, 434, 525, 686, 777, 868, 959, 1001, 1771, 2002, 3003,
        3773, 4774, 5005, 5775, 6006, 7007, 7777, 8008, 8778, 9779);
  }

  private static boolean contains(int[] arr, int n) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == n) {
        return true;
      }
    }
    return false;
  }

  static Stream<Arguments> inputProviderValidMultipleInputs() {
    int[] validNums = { 0, 7, 77, 161, 252, 343, 434, 525, 595, 616, 686, 707, 777, 868, 959, 1001, 1771, 2002, 2772,
        3003, 3773, 4004, 4774, 5005, 5775, 6006, 6776, 7007, 7777, 8008, 8778, 9009, 9779 };
    int numTests = 5;
    Stream<Arguments> inputs = Stream.of();
    for (int i = 0; i < numTests; i++) {
      int numWrongs = (int) (Math.random() * 20);
      ArrayList<Integer> input = new ArrayList<>();
      for (int j = 0; j < numWrongs; j++) {
        int wrong;
        do {
          wrong = (int) (Math.random() * 10000);
        } while (contains(validNums, wrong));
        input.add(wrong);
      }
      input.add(validNums[(int) (Math.random() * validNums.length)]);
      inputs = Stream.concat(inputs, Stream.of(Arguments.of(input)));
    }

    return inputs;
  }

  @ParameterizedTest
  @MethodSource("inputProviderValidOneInput")
  public void printsCorrectMessageWhenHasOneInput(int number) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message when entering a palindrome that is divisible by 7.";
    runWithInput(number + "", new Clause[] {
        new StringLiteral("Entered a palindrome that is divisible by 7. Ending Program."),
    });
  }

  @ParameterizedTest
  @MethodSource("inputProviderValidMultipleInputs")
  public void printsCorrectMessageWithMultipleInputs(ArrayList<Integer> inputs) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message when entering a palindrome that is divisible by 7.";
    Clause[][] outputStrings = getMirrorSevenOutput(inputs);
    String formatedInput = inputs.stream().map(Object::toString).collect(Collectors.joining(" "));
    runWithInput(formatedInput, outputStrings);
  }

  Clause[][] getMirrorSevenOutput(ArrayList<Integer> inputs) {
    Clause[][] outputClause = new Clause[1][inputs.size() * 2 - 1];
    for (int i = 0; i < inputs.size() * 2 - 2; i += 2) {
      outputClause[0][i + 0] = new StringLiteral("Enter an integer\\: ");
      outputClause[0][i + 1] = new NewLine();
    }
    outputClause[0][inputs.size() * 2 - 2] = new StringLiteral(
        "Entered a palindrome that is divisible by 7. Ending Program.");
    return outputClause;
  }
}
