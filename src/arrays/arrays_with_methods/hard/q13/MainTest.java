package arrays.arrays_with_methods.hard.q13;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
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
        TestOption.defaultInput = "6";
        return new Clause[]{
                new StringLiteral("Enter the size of the array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain(){
        ArrayngeOfPrimes.main(new String[0]);
    }

    static Stream<Arguments> isPrimeInputProvider(){
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

    //need main test stream that involves arrays somehow, to construct placeholder

    @ParameterizedTest
    @MethodSource("isPrimeInputProvider")
    void correctIsPrimeMethod(int in, boolean expected) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(ArrayngeOfPrimes.class, "isPrime", new Object[]{in}, int.class);
        CustomAssertions._assertEquals(expected, output, "Your isPrime method does not correctly identify primes.");
    }
}
