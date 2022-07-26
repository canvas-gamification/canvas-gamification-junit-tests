package methods.modular_programming.hard.q1;
import global.BaseTest;
import global.tools.TestOption;
import global.variables.*;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends BaseTest{

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";

        return new Clause[]{
                new StringLiteral("Enter a number"),
                new NewLine(),
                new StringLiteral("true"),
        };
    }

    public void runMain() {
        RightPrime.main(new String[]{});
    }

    @Test
    public void notPrimeAfterTruncationsTest(){
        assertFalse(RightPrime.isRightPrime(1277), "Your program does not check the prime after multiple truncations");
    }

    @Test
    public void largePrimeTest() {
        assertTrue(RightPrime.isRightPrime(59393), "Your program does not handle large right truncatable primes");
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(3, true), Arguments.of(67, false), Arguments.of(345, false));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void variousInputsTest(int inputs, boolean results){
        boolean b = RightPrime.isRightPrime(inputs);
        if(results)
            assertTrue(b, "Your method isRightPrime returned 'false' for an integer that is indeed a right-truncate-prime");
        else
            assertFalse(b, "Your method isRightPrime returned 'true' for an integer that is not a right-truncate-prime");
    }
}
