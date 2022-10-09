package arrays.arrays_with_methods.hard.q13;

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
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java

    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
            103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223,
            227, 229};

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "6";
        return new Clause[]{
                new StringLiteral("Enter the size of the array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        ArrayngeOfPrimes.main(new String[0]);
    }

    static Stream<Arguments> isPrimeInputProvider() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(2, true),
                Arguments.of(4, false),
                Arguments.of(17, true),
                Arguments.of(35, false),
                Arguments.of(53, true),
                Arguments.of(67, true),
                Arguments.of(100, false),
                Arguments.of(101, true),
                Arguments.of(5351, true),
                Arguments.of(5506, false),
                Arguments.of(6723, false),
                Arguments.of(7883, true),
                Arguments.of(27644437, true)
        );
    }

    @ParameterizedTest
    @MethodSource("isPrimeInputProvider")
    void correctIsPrimeMethod(int in, boolean expected) throws Throwable {
        Object[][] arguments = {
                {in, int.class}
        };
        MethodTest m = new MethodTest(ArrayngeOfPrimes.class, "isPrime", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(expected, output, "Your isPrime method does not correctly identify primes.");
    }

    @RepeatedTest(50)
    void correctMainMethodOutput(RepetitionInfo repetitionInfo) throws InvalidClauseException {
        Clause[][] c = new Clause[1][repetitionInfo.getCurrentRepetition() * 2];
        int count = 0;

        for (int x = 0; x < repetitionInfo.getCurrentRepetition(); x++) {
            c[0][count++] = new IntegerLiteral(primes[x]);
            c[0][count++] = new NewLine();
        }

        runWithInput(String.valueOf(repetitionInfo.getCurrentRepetition()), c);
    }
}
