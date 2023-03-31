package methods.using_methods.hard.q9;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
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
        TestOption.defaultInput = "7";
        return new Clause[]{
                new StringLiteral("How many people are going on the trip\\?"),
                new NewLine(),
                new StringLiteral("The total cost of the trip is "),
                new DoubleLiteral("price")
        };
    }

    public void runMain() {
        Tickets.main(new String[0]);
    }

    static Stream<Arguments> tripCostCalcInputProvider() {
        return Stream.of(Arguments.of(6, 24.0), Arguments.of(-5, 0), Arguments.of(0, 0), Arguments.of(2, 10.0), Arguments.of(5, 22.5), Arguments.of(10, 40.0), Arguments.of(11, 33.0));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(Arguments.of("-5", 0), Arguments.of("1", 5.0), Arguments.of("4", 18), Arguments.of("39", 117.0));
    }

    @ParameterizedTest
    @MethodSource("tripCostCalcInputProvider")
    void correctTripCostCalcMethod(int in, double price) throws Throwable {
        Object[][] arguments = {
                {in, int.class}
        };
        MethodTest m = new MethodTest(Tickets.class, "tripCostCalc", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(price, output, "Your tripCostCalc method does not correctly calculate the cost of tickets.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, double price) {
        runWithInput(in);
        assertEquals(price, Double.parseDouble(getItemByName("price")), "Your program does not print the correct output based on the given number of people.");
    }
}
