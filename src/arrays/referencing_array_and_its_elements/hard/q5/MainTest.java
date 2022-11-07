package arrays.referencing_array_and_its_elements.hard.q5;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.arrayToInput;
import static global.utils.ArrayUtil.generateRandomArray;

public class MainTest extends BaseTest {
    // Java

    final static int n = 10;
    final static double pivot = 60.0;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "76.9 50.8 68.4 95.7 88.6 81.2 89.5 74.9 12.76 64.0";
        return new Clause[]{
                new StringLiteral("Enter " + n + " double numbers:"),
                new NewLine(),
                new StringLiteral("The indices of students needing help are:"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        StudentsNeedHelp.main(new String[0]);
    }

    public static String answerFor(double[] a) {
        String ans = "";
        for (int i = 0; i < a.length; i++) {
            if (a[i] < pivot) {
                ans += i + " ";
            }
        }
        return ans.trim();
    }

    static Stream<Arguments> mainInputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(0.0, 100, n)),
                Arguments.of(generateRandomArray(0.0, 100, n)),
                Arguments.of(generateRandomArray(0.0, 100, n))
        );
    }

    @ParameterizedTest
    @MethodSource("mainInputProvider")
    void correctMainMethod(double[] input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your main method does not correctly print the indices of students needing help.";
        runWithInput(
                arrayToInput(input),
                new Clause[]{
                        new StringLiteral(answerFor(input))
                }
        );
    }

    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(0.0, 100, n)),
                Arguments.of(new double[]{}),
                Arguments.of(new double[]{pivot, pivot / 2, pivot - 1}),
                Arguments.of(new double[]{pivot - 1, pivot - 1, pivot}),
                Arguments.of(new double[]{pivot - 1})
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
        MethodTest m = new MethodTest(StudentsNeedHelp.class, "SNH", arguments, methodSentence);
        m.setIncorrectMethodStructureErrorMessage("Your SNH method does not print the correct indices");
        Object output = m.callMethod();
    }
}