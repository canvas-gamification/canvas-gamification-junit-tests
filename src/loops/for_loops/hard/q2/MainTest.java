package loops.for_loops.hard.q2;

import global.BaseTest;
import global.tools.Logger;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1 2 3 4 5 6 7 8 9 10";
        Clause[] c = new Clause[24];
        for(int i = 0; i < 20; i +=2){
            c[i] = new StringLiteral("Enter a number:");
            c[i + 1] = new NewLine();
        }
        c[20] = new StringLiteral("Sum = ");
        c[21] = new DoubleLiteral("sum");
        c[22] = new StringLiteral(" Average = ");
        c[23] = new DoubleLiteral("average");
        return c;
    }

    public void runMain() {
        SumAverageProgram.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)), 55.0, 5.5),
                Arguments.of(new ArrayList<>(Arrays.asList(-104.0, -34.0, 985.0, -45.0, 35.0, 87.0, -87.444, 76.0, 9.0, -452.0)), 469.556, 46.9556),
                Arguments.of(new ArrayList<>(Arrays.asList(79.8, 34.98, 9.87, 5.0, 76.092, 6.0, 10056.78, 54.3, 69.0, 57.92)), 10449.742, 1044.9742));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void computesSumAndAverageCorrectly(ArrayList<Double> list, double sum, double average){
        TestOption.incorrectStructureErrorMessage = "Your program does not take in 10 numbers and computer their sum and average.";
        String s = list.toString();
        s = list.toString().substring(1, s.length()-1).replaceAll(",", "");
        runWithInput(s);
        assertEquals(Double.parseDouble(getItemByName("sum")), sum, 0.001, "Your program does not calculate the sum of the 10 numbers correctly.");
        assertEquals(Double.parseDouble(getItemByName("average")), average, 0.0001, "Your program does not calculate the average of the 10 numbers correctly.");
    }
}
