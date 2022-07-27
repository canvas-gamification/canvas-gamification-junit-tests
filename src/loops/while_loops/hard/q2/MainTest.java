package loops.while_loops.hard.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1 2 3 4 5 6 7 8 9 10";
        return new Clause[]{
                new StringLiteral("Enter a number:"),
                new NewLine(),
                new StringLiteral("Enter a number:"),
                new NewLine(),
                new StringLiteral("Enter a number:"),
                new NewLine(),
                new StringLiteral("Enter a number:"),
                new NewLine(),
                new StringLiteral("Enter a number:"),
                new NewLine(),
                new StringLiteral("Enter a number:"),
                new NewLine(),
                new StringLiteral("Enter a number:"),
                new NewLine(),
                new StringLiteral("Enter a number:"),
                new NewLine(),
                new StringLiteral("Enter a number:"),
                new NewLine(),
                new StringLiteral("Enter a number:"),
                new NewLine(),
                new StringLiteral("Sum = "),
                new DoubleLiteral("sum"),
                new StringLiteral(" Average = "),
                new DoubleLiteral("average")
        };
    }

    public void runMain() {
        SumAverageProgram.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)), 55.0, 5.5),
                Arguments.of(new ArrayList<>(Arrays.asList(3.4, 9.6, 4.5, 89.4, 2.0, -11.35, 45.7, 639.21, 7.69, 24.73)), 814.88, 81.488),
                Arguments.of(new ArrayList<>(Arrays.asList(-45.0, 3.9, -2858.08, 99942.56, 87.2, 0.0, 4.44444, 23.98, 287.9, 2.0)), 97448.90444, 9744.890444));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesSumAndAverageCorrectly(ArrayList<Double> list, double sum, double average) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly take in 10 numbers and calculate their sum and average.";
        String s = list.toString();
        s = s.substring(1, s.length() - 1).replaceAll(",", " ");
        runWithInput(s);
        assertEquals(Double.parseDouble(getItemByName("sum")), sum, 0.000001, "Your program does not correctly calculate the sum of 10 numbers.");
        assertEquals(Double.parseDouble(getItemByName("average")), average, 0.000001, "Your program does not correctly calculate the average of 10 numbers.");
    }
}
