package arrays.arrays_with_methods.hard.q14;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java

    static final double a = 2;
    static final double r = 0.5;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10";
        return new Clause[]{
                new StringLiteral("Enter a value for n: "),
                new NewLine(),
                new StringLiteral("The first "),
                new PlaceHolder(),
                new StringLiteral(" values of the sequence are: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public static double[] methodAns(int n) {
        double[] g = new double[n];
        for (int i = 0; i < n; i++) {
            g[i] = a * Math.pow(r, i);
        }
        return g;
    }

    public void runMain() {
        GeometricSequence.main(new String[0]);
    }

    static Stream<String> InputProvider() {
        String[] st = new String[25];
        for (int i = 0; i < 25; i++)
            st[i] = Integer.toString(i + 1);
        return Stream.of(st);
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void testingMainMethod(String n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not display the correct answer";
        String ans = "";
        for (int i = 0; i < Integer.parseInt(n); i++)
            ans += a * Math.pow(r, i) + " ";
        runWithInput(n, new Clause[]{
                new StringLiteral(n),
                new StringLiteral(ans)});
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(10, methodAns(10)),
                Arguments.of(1, methodAns(1)),
                Arguments.of(0, methodAns(0)),
                Arguments.of(25, methodAns(25))

        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void testingGeometricSequenceMethod(int n, double[] ans) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(GeometricSequence.class, "geometricSequence", new Object[]{n}, int.class);
        CustomAssertions._assertArrayEquals(ans, output, "Your geometricSequence method does not creat the correct sequence");
    }
}
