package arrays.arrays_with_methods.hard.q10;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "3 9";
        return new Clause[]{
                new StringLiteral("Enter two integers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        ArrayofDigits.main(new String[0]);
    }

    static Stream<Arguments> digitIntInputProvider() {
        return Stream.of(
                Arguments.of(100000000, 45),
                Arguments.of(-89, 89),
                Arguments.of(2, 2),
                Arguments.of(473, 0),
                Arguments.of(0, 37),
                Arguments.of(1942, 1000)
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("5 2", 5, 2),
                Arguments.of("999999 100", 999999, 100),
                Arguments.of("-82 3", -82, 3),
                Arguments.of("7 0", 7, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("digitIntInputProvider")
    void correctDigitIntMethod(int a, int b) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class}
        };
        MethodTest m = new MethodTest(ArrayofDigits.class, "digitInt", arguments);
        Object output = m.callMethod();

        int[] arr = new int[b];
        for (int x = 0; x < b; x++)
            arr[x] = a;

        CustomAssertions._assertArrayEquals(arr, output, "Your digitInt method does not return an array of the specified integers to the specified length.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(String in, int a, int b) throws InvalidClauseException {
        Clause[][] c = new Clause[1][b * 2];
        int count = 0;
        for (int x = 0; x < b; x++) {
            c[0][count++] = new IntegerLiteral(a);
            c[0][count++] = new NewLine();
        }

        runWithInput(in, c);
    }
}
