package arrays.referencing_array_and_its_elements.hard.q1;

import arrays.programs_involving_data_sequences.medium.q5.DoTheDeletion;
import global.BaseTest;
import global.tools.CustomAssertions;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class MainTest extends BaseTest {
    // Java

    private static int[] arr = {3, 4, 6, 21, 48, 42, 89, 2, 0, 91, 33};

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * arr.length];
        for (int i = 0; i < 2 * arr.length; i += 2) {
            c[i] = new IntegerLiteral("" + i / 2);
            c[i + 1] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        ALittleToTheRight.main(new String[0]);
    }

    public static int[] answerFor(int[] array) {
        int[] ans = array.clone();
        int last = ans[ans.length - 1];
        for (int i = ans.length - 1; i > 0; i--)
            ans[i] = ans[i - 1];
        ans[0] = last;
        return ans;
    }

    @Test
    public void mainMethodTest() {
        int[] ex = answerFor(arr);
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = Integer.parseInt(getItemByName("" + i));
        }
        assertArrayEquals(ex, ans);
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 6, 21, 48, 42, 89, 2, 0, 91, 33}, new int[]{33, 3, 4, 6, 21, 48, 42, 89, 2, 0, 91}),
                Arguments.of(new int[]{0, 1}, new int[]{1, 0}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{0, 0}, new int[]{0, 0})

        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void LilToDaRightMethodTest(int[] input, int[] ans) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(ALittleToTheRight.class, "LilToDaRight", new Object[]{input}, int[].class);
        CustomAssertions._assertArrayEquals(ans, output, "Your LilToDaRight method does not change the array correctly.");
    }
}
