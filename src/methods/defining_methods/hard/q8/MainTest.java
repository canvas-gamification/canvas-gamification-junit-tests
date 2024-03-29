package methods.defining_methods.hard.q8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "100";
        return new Clause[]{
                new StringLiteral("Enter the cost of rent per month:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The total cost of rent per year is \\$"),
                new DoubleLiteral("rentYearly")
        };
    }

    public void runMain() {
        RentMethod.main(new String[0]);
    }

    static Stream<Arguments> rentPricesProvider() {
        return Stream.of(
                Arguments.of(100.0, 1200.0),
                Arguments.of(200.2435, 2402.922),
                Arguments.of(500.1, 6001.2),
                Arguments.of(600.5, 7206.0),
                Arguments.of(700.99, 8411.88),
                Arguments.of(1000.0, 12000.0),
                Arguments.of(321.344, 3856.128),
                Arguments.of(1.1, 13.2),
                Arguments.of(0, 0));
    }

    @ParameterizedTest
    @MethodSource("rentPricesProvider")
    void correctCalculatesRentMethod(double rentMonthly, double rentYearly) throws Throwable {
        Object[][] arguments = {
                {rentMonthly, double.class}
        };
        MethodTest m = new MethodTest(RentMethod.class, "rentCalc", arguments);
        Object output = m.callMethod();
        String errorMsg = "Your rentCalc() method does not correctly calculate the yearly rent.";
        CustomAssertions._assertEquals(rentYearly, output, 0.00001, errorMsg);
    }

    @ParameterizedTest
    @MethodSource("rentPricesProvider")
    void printsCorrectYearlyRent(double rentMonthly, double rentYearly) {
        String errorMsg = "Your program does not print the correct yearly rent.";
        runWithInput(rentMonthly + "");
        assertEquals(rentYearly, Double.parseDouble(getItemByName("rentYearly")), 0.00001, errorMsg);
    }
}
