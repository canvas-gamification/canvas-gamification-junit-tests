package Arrays.Programs_involving_Data_Sequences.Hard.Q1;

import global.BaseTest;
import global.variables.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends BaseTest {
    int[] inputs = {0, 1, 0, 2, 3, 1, 0, 2, 0};

    public Clause[] testSentence() {
        Clause[] output = new Clause[19];
        for (int x = 0; x < 17; x += 2) {
            output[x] = new IntegerLiteral(inputs[x / 2]);
            output[x + 1] = new NewLine();
        }
        output[18] = new IntegerLiteral(3);
        return output;
    }

    public void runMain() {
        CountAr.main(new String[]{});
    }

    @RepeatedTest(50)
    public void methodTestRandomNums() {
        int[] expected = new int[10];
        int[] passed = new int[10];
        for (int x = 0; x < 10; x++) {
            int n = (int) (Math.random() * 10);
            passed[x] = n;
            expected[n]++;
        }
        int[] actual = CountAr.countThisPlease(passed);

        assertArrayEquals(expected, actual, "Your method did not correctly count for the array: " + Arrays.toString(passed));
    }

    @Test
    public void methodOutOfBoundsException() {

        try {
            int[] hold = CountAr.countThisPlease(new int[]{10, 10, 10, 9, 2, 3, 4, 5, 1, 7, 5});
            fail("Your program should not count numbers larger than 9");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    public void methodPassingAnArrayLargerThan10() {
        int[] expected = new int[10];
        int[] passed = new int[12];
        for (int x = 0; x < passed.length; x++) {
            int n = (int) (Math.random() * 10);
            passed[x] = n;
            expected[n]++;
        }
        int[] actual = CountAr.countThisPlease(passed);
        assertArrayEquals(expected, actual, "Your program did not correctly count all the numbers given in the input");
    }
}
