package arrays.arrays_with_methods.hard.q14;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
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

public class MainTest extends BaseTest {
    // Java

    public static final double a = 2;
    public static final double r = 0.5;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10";
        return new Clause[]{
                new StringLiteral("Enter a value for n:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The first"),
                new Optional(new StringLiteral(" ")),
                new PlaceHolder(),
                new StringLiteral(" values of the sequence are:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public static double[] geometicSeqAnswerFor(int n) {
        double[] g = new double[n];
        for (int i = 0; i < n; i++) {
            g[i] = a * Math.pow(r, i);
        }
        return g;
    }

    public void runMain() {
        GeometricSequence.main(new String[0]);
    }

    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of(10),
                Arguments.of(1),
                Arguments.of(0),
                Arguments.of(25),
                Arguments.of(137),
                Arguments.of(1000)
        );
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void correctMainMethod(int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not display the correct geometric sequence up to the nth term";
        runWithInput(Integer.toString(n), new Clause[]{
                new StringLiteral(Integer.toString(n)),
                new StringLiteral(arrayToInput(geometicSeqAnswerFor(n)))});
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void correctGeometricSequenceMethod(int n) throws Throwable {
        Object[][] arguments = {
                {n, int.class},
        };
        MethodTest m = new MethodTest(GeometricSequence.class, "geometricSequence", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(geometicSeqAnswerFor(n), output,
                "Your geometricSequence method does not correctly return the geometric sequence up to the nth term.");
    }
}
