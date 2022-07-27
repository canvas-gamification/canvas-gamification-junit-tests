package loops.programs_with_repetition.easy.q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import global.variables.wrappers.Optional;
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
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1 6 50 2";
        return new Clause[]{
                new StringLiteral("Enter an integer\\: "),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        ItsAlwaysPrimeTime.main(new String[0]);
    }

    static Stream<Arguments> allPrimeInputs() {
        int[] allPrimesUnder50 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        Stream<Arguments> allPrimeInputs = Stream.of();
        for (int primeNumber : allPrimesUnder50) {
            allPrimeInputs = Stream.concat(allPrimeInputs, Stream.of(Arguments.of(primeNumber)));
        }
        return allPrimeInputs;
    }

    private static Stream<Arguments> repetitiveHardcodedInputs() {
        return Stream.of(
                Arguments.of(new ArrayList<Integer>(Arrays.asList(15, -1, -9, -10, -11, -12, 28, 21, 99, 19))),
                Arguments.of(new ArrayList<Integer>(Arrays.asList(1, 41))),
                Arguments.of(new ArrayList<Integer>(Arrays.asList(50, 41))),
                Arguments.of(new ArrayList<Integer>(Arrays.asList(51, 53, 41))),
                Arguments.of(new ArrayList<Integer>(Arrays.asList(-1, 2))),
                Arguments.of(new ArrayList<Integer>(Arrays.asList(39, 20, 1010, 16, -5, 31))),
                Arguments.of(new ArrayList<Integer>(Arrays.asList(15, -1, -9, -10, -11, -12, 28, 21, 99, 19))),
                Arguments.of(new ArrayList<Integer>(Arrays.asList(-1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12, -51, 47))));
    }

    private static Stream<Arguments> repetitiveRandomlyGeneratedInputs() {
        int[] allPrimesUnder50 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        int[] allCompositesUnder50AndNegatives = {1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28,
                30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12};
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

    static Stream<Arguments> repetitiveInputs() {
        return Stream.concat(repetitiveHardcodedInputs(), repetitiveRandomlyGeneratedInputs());
    }

    @ParameterizedTest
    @MethodSource("allPrimeInputs")
    public void printsCorrectMessageWithValidInput(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message when a valid input is entered.";
        runWithInput(String.valueOf(input), new Clause[][]{{
                new StringLiteral("Entered a prime number that is less than 50. Ending Program."),
                new Optional(new StringLiteral(" "))
        }});
    }

    @ParameterizedTest
    @MethodSource("repetitiveInputs")
    public void loopsUntilValidInputIsReceived(ArrayList<Integer> inputs) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not stop when it encounters a prime number that is less than 50.";
        String formatedInput = inputs.stream().map(Object::toString).reduce("", (a, b) -> a + " " + b);
        Clause[][] expectedOutput = getPrimeTimeOutputClause(inputs);

        runWithInput(formatedInput, expectedOutput);
    }

    private Clause[][] getPrimeTimeOutputClause(ArrayList<Integer> inputs) {
        Clause[][] outputClause = new Clause[1][inputs.size() * 2];
        for (int i = 0; i < inputs.size() * 2 - 2; i += 2) {
            outputClause[0][i + 0] = new StringLiteral("Enter an integer\\: ");
            outputClause[0][i + 1] = new NewLine();
        }
        outputClause[0][inputs.size() * 2 - 2] = new StringLiteral(
                "Entered a prime number that is less than 50. Ending Program.");
        outputClause[0][inputs.size() * 2 - 1] = new Optional(new StringLiteral(" "));
        return outputClause;
    }
}
