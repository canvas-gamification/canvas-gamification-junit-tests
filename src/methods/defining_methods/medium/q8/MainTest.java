package methods.defining_methods.medium.q8;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "4.4 8";
        return new Clause[]{
                new StringLiteral("Please enter the weight of the flour: "),
                new NewLine(),
                new StringLiteral("Please enter the price if the flour: "),
                new NewLine(),
                new StringLiteral("The cost per kg of the flour is: "),
                new DoubleLiteral("price")
        };
    }

    public void runMain() {
        FlourPower.main(new String[0]);
    }

    static Stream<Arguments> costPerCalcInputProvider() {
        return Stream.of(
                Arguments.of(5, 5, 1.0),
                Arguments.of(2.5, 8, 3.2),
                Arguments.of(3, 15.2, 5.066666666666666),
                Arguments.of(6.2, 16.3, 2.629032258064516),
                Arguments.of(-5, 13, -1.0),
                Arguments.of(1234567, 87, 7.047005144313756E-5),
                Arguments.of(23, 456789, 19860.391304347828),
                Arguments.of(4.5, -11.0, -1.0)
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(Arguments.of("4.5 12", 2.6666666666666665), Arguments.of("3951 54", 0.01366742596810934), Arguments.of("67 -1234", -1.0));
    }

    @ParameterizedTest
    @MethodSource("costPerCalcInputProvider")
    void correctCostPerCalcMethod(double weight, double cost, double price) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(FlourPower.class, "costPerCalc", new Object[]{weight, cost}, double.class, double.class);
        CustomAssertions._assertEquals(price, output, 0.000001, "Your costPerCalc method does not calculate the correct price per kg.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, double price) {
        runWithInput(in);
        assertEquals(price, Double.parseDouble(getItemByName("price")), 0.00001, "Your program does not print the correct cost per kg.");
    }
}
