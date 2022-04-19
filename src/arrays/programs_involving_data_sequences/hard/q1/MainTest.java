package arrays.programs_involving_data_sequences.hard.q1;

import global.BaseTest;
import global.variables.*;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import org.junit.jupiter.api.Test;

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

    @Test
    public void methodNumbersLargerThan9() {
        try {
            int[] hold = CountAr.countThisPlease(new int[]{10, 10, 10, 9, 2, 3, 4, 5, 1, 7, 5});
            fail("Your program should not count numbers larger than 9");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    public void methodPassingAnArrayLargerThan10() {
        int[] passed = {1, 3, 4, 3, 4, 1, 4, 9, 9, 7, 7, 3, 7, 3, 1, 9, 0};
        int[] expected = {1, 3, 0, 4, 3, 0, 0, 3, 0, 3};
        int[] actual = CountAr.countThisPlease(passed);
        assertArrayEquals(expected, actual, "Your program did not correctly count all the numbers when the input had more than 10 numbers.");
    }

    @Test
    public void methodPassingAnArraySmallerThan10() {
        int[] passed = {1, 3, 4, 1, 9, 0};
        int[] expected = {1, 2, 0, 1, 1, 0, 0, 0, 0, 1};
        int[] actual = CountAr.countThisPlease(passed);
        assertArrayEquals(expected, actual, "Your program did not correctly count all the numbers given in the input when the input had less than 10 numbers.");
    }

    @Test
    public void methodPassingAnArrayOfExactly10() {
        int[] passed = {1, 3, 4, 6, 4, 9, 4, 8, 9, 7, 0, 3};
        int[] expected = {1, 1, 0, 2, 3, 0, 1, 1, 1, 2};
        int[] actual = CountAr.countThisPlease(passed);
        assertArrayEquals(expected, actual, "Your program did not correctly count all the numbers given in the input when the input had exactly 10 numbers.");
    }

    @Test
    public void methodRepeatedNumber() {
        int[] passed = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] expected = {0, 10, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] actual = CountAr.countThisPlease(passed);
        assertArrayEquals(expected, actual, "Your program did not correctly count all the numbers when they were identical.");
    }

    @Test
    public void methodNoRepeatedNumbers() {
        int[] passed = {0, 1, 2, 3, 5, 4, 6, 7, 8, 9};
        int[] expected = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] actual = CountAr.countThisPlease(passed);
        assertArrayEquals(expected, actual, "Your program did not correctly count all the numbers when there were no repeated numbers.");
    }

    @Test
    public void methodEmptyArray() {
        int[] passed = {};
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] actual = CountAr.countThisPlease(passed);
        assertArrayEquals(expected, actual, "Your program did not correctly handle an empty array.");
    }
}
