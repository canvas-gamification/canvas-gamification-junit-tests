package arrays.referencing_array_and_its_elements.hard.q4;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.arrayToInput;
import static global.utils.ArrayUtil.generateRandomArray;

public class MainTest extends BaseTest {
    // Java

    final static int n = 10;
    final static double pivot = 88.0;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(generateRandomArray(-100, 100, n));
        return new Clause[]{
                new StringLiteral("Enter " + n + " double numbers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The indices of potential candidates for teaching assistants are:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        PotentialGoodStudents.main(new String[0]);
    }

    public static String answerFor(double[] a) {
        String ans = "";
        for (int i = 0; i < a.length; i++) {
            if (a[i] > pivot) {
                ans += i + " ";
            }
        }
        return ans.trim();
    }

    static Stream<Arguments> mainInputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(0.0, 100, n)),
                Arguments.of(generateRandomArray(0.0, 100, n)),
                Arguments.of(generateRandomArray(0.0, 100, n)),
                Arguments.of(generateRandomArray(pivot, 100, n)),
                Arguments.of(generateRandomArray(0.0, pivot, n))
        );
    }

    @ParameterizedTest
    @MethodSource("mainInputProvider")
    void correctMainMethod(double[] input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your main method does not correctly print the indices of the potential teaching assistants.";
        runWithInput(
                arrayToInput(input),
                new Clause[]{
                        new StringLiteral(answerFor(input))
                }
        );
    }

    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(0.0, 100, 10000)),
                Arguments.of(generateRandomArray(pivot, 100, 10000)),
                Arguments.of(generateRandomArray(0.0, pivot, 10000)),
                Arguments.of(new double[]{}),
                Arguments.of(new double[]{pivot, pivot / 2, pivot + 0.00001}),
                Arguments.of(new double[]{pivot + 0.00001, pivot + 0.00001, pivot}),
                Arguments.of(new double[]{pivot + 0.00001})
        );
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void testForPGSMethod(double[] input) throws Throwable {
        Clause[] methodSentence = new Clause[]{
                new StringLiteral(answerFor(input))
        };
        Object[][] arguments = {
                {input, double[].class},
        };
        MethodTest m = new MethodTest(PotentialGoodStudents.class, "PGS", arguments, methodSentence);
        m.setIncorrectMethodStructureErrorMessage("Your PGS method does not print the correct indices");
        Object output = m.callMethod();
    }
}

