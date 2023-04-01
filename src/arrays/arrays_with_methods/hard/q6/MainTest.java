package arrays.arrays_with_methods.hard.q6;

import global.MethodTest;
import global.utils.ArrayUtil;
import global.variables.clauses.RandomInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTest {
    // Java

    public static Stream<Integer> randomReplaceInput(){
        return Stream.of(3, 4, 5, 6, 7, 50);
    }

    @ParameterizedTest
    @MethodSource("randomReplaceInput")
    public void correctRandomReplaceMethod(int size) throws Throwable {
        int[] arr = ArrayUtil.generateAscendingArray(1, size);
        int[][] storeRandoms = new int[(size+1)/2][1000];

        Object[][] arguments = {
                {arr, int[].class}
        };
        MethodTest m = new MethodTest(ShrinkItDown.class, "randomReplace", arguments);

        Object output = m.callMethod();
        int[] hold = new int[0];
        try {
            hold = (int[]) output;
        } catch (Exception e) {
            Assertions.fail("Your createRandomArray method does not return an array of integers.");
        }

        int count = 0;
        int repetitions = 0;
        //get first round of numbers
        for(int x = 0; x < size; x++){
            if( x % 2 == 0 )
                storeRandoms[count++][repetitions] = hold[x];
        }
        repetitions++;

        //now rest of numbers
        for(int x = 0; x < 999; x ++){
            arr = ArrayUtil.generateAscendingArray(1, size);
            count = 0;
            output = m.callMethod();
            hold = (int[]) output;
            for(int y = 0; y < size; y++){
                if( y % 2 == 0 )
                    storeRandoms[count++][repetitions] = hold[y];
            }
            repetitions++;
        }

        int index = 0;
        for (int[] storeRandom : storeRandoms) {
            ArrayList<Integer> response = Arrays.stream(storeRandom).boxed().collect(Collectors.toCollection(ArrayList::new));
            RandomInteger randomInteger = new RandomInteger(0, index+2);
            index += 2;
            randomInteger.validateRandom(response);
        }

    }

}
