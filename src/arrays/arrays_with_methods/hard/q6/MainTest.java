package arrays.arrays_with_methods.hard.q6;

import global.MethodTest;
import global.tools.CustomAssertions;
import global.utils.ArrayUtil;
import global.variables.clauses.RandomInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    public static Stream<Integer> randomReplaceInput() {
        return Stream.of(3, 4, 5, 6, 7, 50);
    }

    @Test
    public void randomReplaceMethodKeepsOddIndexNumber() throws Throwable {
        //this checks that the odd index numbers are not modified
        int[] arr = {2, 43, 342, 5, 324, 543, 543, 6, 43, 634, 49, 236, 246, 2673653, 7653};
        int[] solutions = {43, 5, 543, 6, 634, 236, 2673653};
        Object[][] arguments = {
                {arr, int[].class}
        };
        MethodTest m = new MethodTest(ShrinkItDown.class, "randomReplace", arguments);
        if (m.getMethodReturnType() != int[].class) {
            Assertions.fail("Your createRandomArray method does not return an array of integers.");
        }
        int[] output = (int[]) m.callMethod();
        int[] oddNums = new int[7];
        int count = 0;
        for (int x = 0; x < output.length; x++) {
            if (x % 2 == 1)
                oddNums[count++] = output[x];
        }
        CustomAssertions._assertArrayEquals(solutions, oddNums, "Your program does not modify only the even indexed elements.");
    }

    @ParameterizedTest
    @MethodSource("randomReplaceInput")
    public void correctRandomReplaceMethod(int size) throws Throwable {
        //generates the input array
        int[] arr = ArrayUtil.generateAscendingArray(1, size);
        //an array of the arrays storing the generated numbers at each even index
        int[][] storeRandoms = new int[(size + 1) / 2][1000];

        Object[][] arguments = {
                {arr, int[].class}
        };
        MethodTest m = new MethodTest(ShrinkItDown.class, "randomReplace", arguments);
        if (m.getMethodReturnType() != int[].class) {
            Assertions.fail("Your createRandomArray method does not return an array of integers.");
        }

        int repetitions = 0;

        //runs the program 1000 times and stores all the even index numbers generated. Each are in their own array
        //because each index has its own range the variables can fall in (I'm effectively using ascending array to control that)
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < size; y++) {
                arr[y] = y + 1;
            }
            int count = 0;
            int[] output = (int[]) m.callMethod();
            for (int y = 0; y < size; y++) {
                if (y % 2 == 0)
                    storeRandoms[count++][repetitions] = output[y];
            }
            repetitions++;
        }

        //checks randomization
        int index = 0;
        for (int[] storeRandom : storeRandoms) {
            ArrayList<Integer> response = Arrays.stream(storeRandom).boxed().collect(Collectors.toCollection(ArrayList::new));
            RandomInteger randomInteger = new RandomInteger(0, index + 2);
            index += 2;
            assertTrue(randomInteger.validateRandom(response), "Your randomReplace method does not correctly randomize every 2nd number");
        }
    }
}
