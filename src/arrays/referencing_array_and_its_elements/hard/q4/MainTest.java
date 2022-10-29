package arrays.referencing_array_and_its_elements.hard.q4;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java

    final static double[] arr = {76.9, 50.8, 68.4, 95.7, 88.6, 81.2, 89.5, 74.9, 12.76, 64.0};
    final static double pivot = 88.0;

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral(answerFor(arr))
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

    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of(arr, answerFor(arr)),
                Arguments.of(new double[]{}, answerFor(new double[]{})),
                Arguments.of(new double[]{pivot, pivot / 2, pivot + 1}, answerFor(new double[]{pivot, pivot / 2, pivot + 1})),
                Arguments.of(new double[]{pivot + 1, pivot + 1, pivot}, answerFor(new double[]{pivot + 1, pivot + 1, pivot})),
                Arguments.of(new double[]{pivot + 1}, answerFor(new double[]{pivot + 1}))
        );
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void testForPGSMethod(double[] input, String ans) throws Throwable {
        Clause[] methodSentence = new Clause[]{
                new StringLiteral(ans)
        };
        Object[][] arguments = {
                {input, double[].class},
        };
        MethodTest m = new MethodTest(PotentialGoodStudents.class, "PGS", arguments, methodSentence);
        m.setIncorrectMethodStructureErrorMessage("Your PGS method does not print the correct indices");
        Object output = m.callMethod();
    }
}

