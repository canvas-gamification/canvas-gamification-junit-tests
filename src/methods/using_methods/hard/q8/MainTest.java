package methods.using_methods.hard.q8;

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
        TestOption.defaultInput = "19";
        return new Clause[]{
                new StringLiteral("What is the current temperature in Celsius:"),
                new NewLine(),
                new StringLiteral("The current temperature in Fahrenheit is "),
                new DoubleLiteral("converted")
        };
    }

    public void runMain(){Celverter.main(new String[0]);}

    static Stream<Arguments> tempCalcInputProvider(){
        return Stream.of(Arguments.of(0, 32.0), Arguments.of(20.7, 69.25999999999999), Arguments.of(45.3, 113.53999999999999), Arguments.of(2.2, 35.96), Arguments.of(-11, 12.2), Arguments.of(-24.9, -12.82));
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(Arguments.of("5", 41.0), Arguments.of("53", 127.4), Arguments.of("21.3", 70.34), Arguments.of("-31", -23.800000000000004));
    }

    @ParameterizedTest
    @MethodSource("tempCalcInputProvider")
    void correctTempCalcMethod(double in, double con) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(Celverter.class, "tempCalc", new Object[]{in}, double.class);
        CustomAssertions._assertEquals(con, output, 0.01, "Your method tempCalc does not correctly calculate the temperature in Fahrenheit.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, double ans){
        runWithInput(in);
        assertEquals(ans, Double.parseDouble(getItemByName("converted")), 0.01, "Your program does not print the correct message based on the input temperature.");
    }
}
