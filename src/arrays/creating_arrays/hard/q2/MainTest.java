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

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("0 55 64 13 7356", 0, 55, 46, 31, 6537),
                Arguments.of("319 404 257 123 666", 913, 404, 752, 321, 666),
                Arguments.of("10000 43 7 8273 4372", 1, 34, 7, 3728, 2734)
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
        CustomAssertions._assertEquals(ans, output, "Your reverse method does not correctly reverse the given number.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, int one, int two, int three, int four, int five) {
        runWithInput(in);
        assertEquals(one, Integer.parseInt(getItemByName("one")), "Your program does not correctly reverse the first number");
        assertEquals(two, Integer.parseInt(getItemByName("two")), "Your program does not correctly reverse the second number");
        assertEquals(three, Integer.parseInt(getItemByName("three")), "Your program does not correctly reverse the third number");
        assertEquals(four, Integer.parseInt(getItemByName("four")), "Your program does not correctly reverse the fourth number");
        assertEquals(five, Integer.parseInt(getItemByName("five")), "Your program does not correctly reverse the fifth number");
    }

    public Clause[] clauseBuilder(){
        Clause[] c = new Clause[num*5];
        int count = 0;

        for(int x = 0; x < num; x++){
            c[count++] = new StringLiteral("Enter a number to add to the array:");
            c[count++] = new Optional(new StringLiteral(" "));
            c[count++] = new NewLine();
        }
        for(int x = 0; x < num; x++){
            c[count++] = new IntegerLiteral("num" + x);
            c[count++] = new NewLine();
        }

        return c;
    }
}
