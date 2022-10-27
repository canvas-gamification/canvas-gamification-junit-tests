package methods.defining_methods.medium.q7;

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
        TestOption.defaultInput = "12 14";
        return new Clause[]{
                new StringLiteral("Please enter the diameter of the first pizza: "),
                new NewLine(),
                new StringLiteral("Please enter the diameter of the second pizza: "),
                new NewLine(),
                new StringLiteral("The pizza with the greatest area is the pizza with diameter: "),
                new DoubleLiteral("greatest")
        };
    }

    public void runMain() {
        PizzaPizza.main(new String[0]);
    }

    static Stream<Arguments> greaterSizeInputProvider() {
        return Stream.of(
                Arguments.of(1, 1, 1.0),
                Arguments.of(23, 22.9, 23.0),
                Arguments.of(4567, 7654, 7654.0),
                Arguments.of(61.8, 4488765.3, 4488765.3),
                Arguments.of(-45, 3, -1),
                Arguments.of(25.34, -11.2546879, -1.0)
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("34 56", 56.0),
                Arguments.of("36.2 54.1", 54.1),
                Arguments.of("-4 2", -1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("greaterSizeInputProvider")
    void correctGreaterAreaMethod(double first, double second, double greatest) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(PizzaPizza.class, "greaterArea", new Object[]{first, second}, double.class, double.class);
        CustomAssertions._assertEquals(greatest, output, 0.0001, "Your greaterArea method does not correctly identify the pizza with the greatest area.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, double greatest) {
        runWithInput(in);
        assertEquals(greatest, Double.parseDouble(getItemByName("greatest")), 0.0001, "Your program does not print out the correct diameter.");
    }
}
