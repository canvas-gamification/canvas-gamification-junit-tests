package arrays.programs_involving_data_sequences.easy.q7;

import global.BaseTest;
import global.MethodTest;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons

    final static int upperBound = 101;

    public Clause[] testSentence() {
        return new Clause[]{
                new IntegerLiteral(3)
        };
    }

    public void runMain(){
        WhereIsIt.main(new String[0]);
    }

    static Stream<int[]> smallestFinderInputProvider(){
        return Stream.of(
                new int[]{1, 2, 3, 4, 5, 6},
                new int[]{7, 10, 0, 3},
                new int[]{upperBound-1, upperBound-2, upperBound-1, 78, 99, 98, 82},
                new int[]{},
                ArrayUtil.generateRandomArray(0, upperBound, 20),
                ArrayUtil.generateRandomArray(0, upperBound, 2),
                ArrayUtil.generateRandomArray(0, upperBound, 50),
                ArrayUtil.generateRandomArray(0, upperBound, 100),
                ArrayUtil.generateRandomArray(0, upperBound, 250)
        );
    }

    @ParameterizedTest
    @MethodSource("smallestFinderInputProvider")
    void correctSmallestFinderMethod(int[] arr) throws Throwable {
        int small = getSmallestElement(arr);
        Object[][] arguments = {
                {arr, int[].class}
        };
        MethodTest m = new MethodTest(WhereIsIt.class, "smallestFinder", arguments);
        Object output = m.callMethod();
        assertEquals(small, output, "Your smallestFinder method does not correctly identify the smallest element.");
    }

    int getSmallestElement(int[] arr){
        if(arr.length == 0)
            return upperBound;
        int small = arr[0];
        for(int x = 1; x < arr.length; x++){
            if(small > arr[x])
                small = arr[x];
        }
        return small;
    }
}
