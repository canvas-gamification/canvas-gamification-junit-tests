package Arrays.Programs_involving_Data_Sequences.Hard.Q1;

import global.BaseTest;
import global.variables.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CountArTest extends BaseTest{
    public Clause[] testSentence() {
        return new Clause[]{
                new IntegerLiteral(0),
                new NewLine(),
                new IntegerLiteral(1),
                new NewLine(),
                new IntegerLiteral(0),
                new NewLine(),
                new IntegerLiteral(2),
                new NewLine(),
                new IntegerLiteral(3),
                new NewLine(),
                new IntegerLiteral(1),
                new NewLine(),
                new IntegerLiteral(0),
                new NewLine(),
                new IntegerLiteral(2),
                new NewLine(),
                new IntegerLiteral(0),
                new NewLine(),
                new IntegerLiteral(3),
        };
    }

    public void runMain() {
        CountAr.main(new String[]{});
    }

    @RepeatedTest(50)
    public void methodTestRandomNums(){
        int[] expected = new int[10];
        int[] passed = new int[10];
        for(int x = 0; x <10; x++){
            int n = (int)(Math.random()*10);
            passed[x] = n;
            expected[n]++;
        }
        int[] actual = CountAr.countThisPlease(passed);

        assertArrayEquals(expected, actual, "Expected output: " + Arrays.toString(expected) + " Received output: " + Arrays.toString(actual));
    }

    @Test
    public void methodOutOfBoundsException(){

        try{
            //noinspection ResultOfMethodCallIgnored
            CountAr.countThisPlease(new int[]{10, 10, 10, 9, 2,3,4,5,1,7, 5});
            fail("Returning array is larger than it should be");
        }
        catch (IndexOutOfBoundsException e){
            assertTrue(true);
        }
    }
    @Test
    public void methodPassingAnArrayLargerThan10(){
        int[] expected = {1, 2, 3, 0, 1, 1, 1, 1, 0, 1};
        int[] actual = CountAr.countThisPlease(new int[]{2, 2, 4, 2, 1, 9, 5, 1, 6, 0, 7});
        assertArrayEquals(expected, actual, "Your program did not count all the passed numbers");
    }
}
