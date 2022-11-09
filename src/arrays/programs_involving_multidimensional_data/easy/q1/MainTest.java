package arrays.programs_involving_multidimensional_data.easy.q1;

import global.BaseTest;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons

    static final int size = 4;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1 2 3 4 4 3 2 1 2 4 1 3 3 4 2 1";
        return clauseBuilder();
    }

    public void runMain(){
        AllSameSum.main(new String[0]);
    }

    static Stream<int[][]> inputProvider(){
        int[][] one = new int[size][size];
        for(int x = 0; x < size; x ++){
            one[x] = ArrayUtil.generateRandomArray(0, 10, size);
        }
        int[][] two = new int[size][size];
        for(int x = 0; x < size; x ++){
            two[x] = ArrayUtil.generateRandomArray(5, 5, size);
        }
        int[][] three = new int[size][size];
        for(int x = 0; x < size; x ++){
            three[x] = ArrayUtil.generateRandomArray(10, 100, size);
        }
        int[][] four = new int[size][size];
        for(int x = 0; x < size; x ++){
            four[x] = ArrayUtil.generateRandomArray(0, 10, size);
        }
        int[][] five = new int[size][size];
        for(int x = 0; x < size; x ++){
            five[x] = ArrayUtil.generateRandomArray(10, 20, size);
        }
        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                five[x][y] *= -1;
            }
        }

        return Stream.of(one, two, three, four, five);
    }

    public Clause[] clauseBuilder(){
        Clause[] c = new Clause[size*size*2+1];

        int count = 0;

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                c[count++] = new StringLiteral("Enter the value for row " + x + " column " + y + ": ");
                c[count++] = new NewLine();
            }
        }

        c[count] = new PlaceHolder();

        return c;
    }
}
