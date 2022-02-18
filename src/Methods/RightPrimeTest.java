package Methods;
import global.BaseTest;
import global.variables.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import temp.RightPrime;

import static org.junit.jupiter.api.Assertions.*;

public class RightPrimeTest extends BaseTest{

    public Clause[] testSentence() {
        provideInput("5");
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

    int[] in = {3, 67, 345};
    boolean [] boo = {true, false, false};
    @RepeatedTest(3)
    public void variousInputsTest(RepetitionInfo n){
        boolean b = RightPrime.isRightPrime(in[n.getCurrentRepetition()-1]);
        if(boo[n.getCurrentRepetition()-1])
            assertTrue(b);
        else
            assertFalse(b);
    }
}
