package arrays.referencing_array_and_its_elements.hard.q3;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java

    static int[] arr = {3, 4, 6, 21, 48, 42, 89, 2, 5, 91};

    public Clause[] testSentence() {
        return new Clause[]{
                new PlaceHolder()
        };
    }

    public void runMain() {
        EvenorOdd.main(new String[0]);
    }

    public static String answerFor(int[] a) {
        String ans = "";
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0)
                ans += a[i] + " ";
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0)
                ans += a[i] + " ";
        }
        return ans.trim();
    }

    @Test
    public void testForMainMethod() throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your main method does not print the correct answer";
        runWithInput(String.valueOf(arr), new Clause[]{
                new StringLiteral(answerFor(arr))
        });
    }

    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 6, 21, 48, 42, 89, 2, 5, 91}, "4 6 48 42 2 3 21 89 5 91"),
                Arguments.of(new int[]{}, ""),
                Arguments.of(new int[]{1, 3, 5}, "1 3 5"),
                Arguments.of(new int[]{2, 4, 6}, "2 4 6"),
                Arguments.of(new int[]{5, 3, 1, 6, 4, 2}, "6 4 2 5 3 1")
        );
    }


    @ParameterizedTest
    @MethodSource("InputProvider")
    void testForEvenorOddMethod(int[] input, String ans) throws Throwable {
        Object[][] arguments = {
                {input, int[].class},
        };
        MethodTest m = new MethodTest(EvenorOdd.class, "EorO", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(ans, output,
                "Your EorO method does not return the correct string of numbers");


    }
}
