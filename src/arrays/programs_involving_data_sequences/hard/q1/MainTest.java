package arrays.programs_involving_data_sequences.hard.q1;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.*;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends BaseTest {
    int[] programOutput = {0, 1, 0, 2, 3, 1, 0, 2, 0, 3};

    public Clause[] testSentence() {
        Clause[] clause = new Clause[20];
        int a = 0;
        int c = 0;
        while (a < 10) {
            clause[c++] = new IntegerLiteral(programOutput[a]);
            clause[c++] = new NewLine();
            a++;
        }
        return clause;
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
        int[] passed = new int[30];
        for (int x = 0; x < passed.length; x++) {
            int n = (int) (Math.random() * 10);
            passed[x] = n;
            expected[n]++;
        }
        int[] actual = CountAr.countThisPlease(passed);
        assertArrayEquals(expected, actual, "Your program did not correctly count all the numbers given in the input");
    }
}
