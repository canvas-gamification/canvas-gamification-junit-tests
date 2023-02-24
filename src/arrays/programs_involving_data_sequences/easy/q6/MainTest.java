package arrays.programs_involving_data_sequences.easy.q6;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons

    final static int size = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray(30.0, 500.0, size * 2));
        return clauseBuilder();
    }

    public void runMain() {
        BMWhy.main(new String[0]);
    }

    static Stream<Arguments> calculateBMIInputProvider() {
        return Stream.of(
                Arguments.of(1, 1, 1.0),
                Arguments.of(1678653.5, 78.5632, 2.7880274413278936E-11),
                Arguments.of(153, 57392648.78, 2451.734323550771),
                Arguments.of(180, 67, 0.002067901234567901),
                Arguments.of(213, 98.4, 0.0021688818356146266),
                Arguments.of(112.57, 45.23, 0.003569285235992925),
                Arguments.of(70, 198, 0.04040816326530612),
                Arguments.of(63.5, 153.2, 0.03799367598735197),
                Arguments.of(57.453, 97.21, 0.029450015055210627)
        );
    }

    static Stream<double[]> mainMethodInputProvider() {
        return Stream.of(
                ArrayUtil.generateRandomArray(30.0, 500.0, size * 2),
                ArrayUtil.generateRandomArray(30.0, 500.0, size * 2),
                ArrayUtil.generateRandomArray(30.0, 500.0, size * 2)
        );
    }

    @ParameterizedTest
    @MethodSource("calculateBMIInputProvider")
    void correctCalculateBMIMethod(double height, double weight, double bmi) throws Throwable {
        Object[][] arguments = {
                {height, double.class},
                {weight, double.class}
        };
        MethodTest m = new MethodTest(BMWhy.class, "calculateBMI", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(bmi, output, 0.00000001, "Your calculateBMI method does not correctly calculate bmi based on the input height and weight.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(double[] values) {
        double[] bmis = new double[size];
        int count = 0;
        for (int x = 0; x < size; x++) {
            bmis[x] = values[count + 1] / Math.pow(values[count], 2);
            count += 2;
        }

        StringBuilder s = new StringBuilder();
        for (int x = 0; x < size * 2; x++) {
            s.append(values[x]);
            s.append(" ");
        }

        runWithInput(s.toString());

        for (int x = 0; x < size; x++) {
            assertEquals(bmis[x], Double.parseDouble(getItemByName(String.valueOf(x + 1))), 0.00000001, "Your program did not correctly calculate BMI.");
        }
    }

    public Clause[] clauseBuilder() {
        Clause[] c = new Clause[size * 3 + 5];

        c[0] = new StringLiteral("Enter the Height and Weight of ");
        c[1] = new IntegerLiteral("size");
        c[2] = new StringLiteral(" people in pairs:");
        c[3] = new Optional(new StringLiteral(" "));
        c[4] = new NewLine();

        int count = 1;

        for (int x = 5; x < size * 3 + 5; x += 3) {
            c[x] = new StringLiteral("BMI " + count + ": ");
            c[x + 1] = new DoubleLiteral(String.valueOf(count));
            c[x + 2] = new NewLine();
            count++;
        }

        return c;
    }
}
