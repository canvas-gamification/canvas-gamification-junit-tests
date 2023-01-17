package arrays.creating_arrays.hard.q2;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    final static int num = 5;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray(5, 200, num));
        return clauseBuilder();
    }

    public void runMain() {
        RevdArray.main(new String[0]);
    }

    static Stream<Arguments> reverseInputProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(1000, 1),
                Arguments.of(24, 42),
                Arguments.of(3109, 9013),
                Arguments.of(9, 9),
                Arguments.of(73821, 12837),
                Arguments.of(73, 37)
        );
    }

    static Stream<int[]> mainMethodInputProvider() {
        return Stream.of(
                ArrayUtil.generateRandomArray(5, 200, num),
                ArrayUtil.generateRandomArray(5, 200, num),
                ArrayUtil.generateRandomArray(5, 200, num),
                ArrayUtil.generateRandomArray(5, 200, num)
        );
    }

    @ParameterizedTest
    @MethodSource("reverseInputProvider")
    void correctReverseMethod(int in, int ans) throws Throwable {
        Object[][] arguments = {
                {in, int.class}
        };
        MethodTest m = new MethodTest(RevdArray.class, "reverse", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(ans, output, "Your reverse method does not correctly reverse the input integer.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(int[] in) {
        runWithInput(ArrayUtil.arrayToInput(in));

        for(int x = 0; x < in.length; x++){
            assertEquals(solution(in[x]), Integer.parseInt(getItemByName("num" + x)), "Your program does not correctly reverse each element in the array.");
        }

    }

    public Clause[] clauseBuilder(){
        Clause[] c = new Clause[num*5+3];
        int count = 0;

        for(int x = 0; x < num; x++){
            c[count++] = new StringLiteral("Enter a number to add to the array:");
            c[count++] = new Optional(new StringLiteral(" "));
            c[count++] = new NewLine();
        }
        c[count++] = new StringLiteral("The numbers in the array are:");
        c[count++] = new Optional(new StringLiteral(" "));
        c[count++] = new NewLine();
        for(int x = 0; x < num; x++){
            c[count++] = new IntegerLiteral("num" + x);
            c[count++] = new NewLine();
        }

        return c;
    }

    public static int solution(int n) {
        String hold = String.valueOf(n);
        StringBuilder reversed = new StringBuilder();
        for(int x = hold.length()-1; x >= 0; x--){
            reversed.append(hold.charAt(x));
        }
        return Integer.parseInt(String.valueOf(reversed));
    }
}
