package methods.defining_methods.hard.q2;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5.0";
        return new Clause[]{
                new StringLiteral("Enter the radius of the circle:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The area of the circle is:"),
                new Optional(new StringLiteral(" ")),
                new DoubleLiteral("area"),
                new NewLine(),
                new StringLiteral("The circumference of the circle is:"),
                new Optional(new StringLiteral(" ")),
                new DoubleLiteral("circumference")
        };
    }

    public void runMain() {
        RadOfCircle.main(new String[0]);
    }

    static Stream<Arguments> areaCalcInputProvider() {
        return Stream.of(Arguments.of(5, 78.53981633974483), Arguments.of(0, 0.0), Arguments.of(-45.96, 0.0),
                Arguments.of(-0.0001, 0.0), Arguments.of(429.83, 580421.2715948255));
    }

    static Stream<Arguments> circCalcInputProvider() {
        return Stream.of(Arguments.of(5, 31.41592653589793), Arguments.of(0, 0.0), Arguments.of(-45.96, 0.0),
                Arguments.of(-0.0001, 0.0), Arguments.of(429.83, 2700.7015405850016));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(Arguments.of(5, 78.54, 31.42), Arguments.of(0, 0.0, 0.0), Arguments.of(-45.96, 0.0, 0.0),
                Arguments.of(429.83, 580421.27, 2700.70));
    }

    @ParameterizedTest
    @MethodSource("areaCalcInputProvider")
    void correctAreaCalcMethod(double radius, double area) throws Throwable {
        Object[][] arguments = {
                {radius, double.class}
        };
        MethodTest m = new MethodTest(RadOfCircle.class, "areaCalc", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(area, output, 0.0000001, "Your areaCalc method does not correctly calculate the area of a circle.");
    }

    @ParameterizedTest
    @MethodSource("circCalcInputProvider")
    void correctCircCalcMethod(double radius, double circumference) throws Throwable {
        Object[][] arguments = {
                {radius, double.class}
        };
        MethodTest m = new MethodTest(RadOfCircle.class, "circCalc", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(circumference, output, 0.0000001, "Your circCalc method does not correctly calculate the circumference of a circle.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(double radius, double area, double circumference) {
        runWithInput(String.valueOf(radius));
        assertEquals(Double.parseDouble(getItemByName("area")), area, 0.001, "Your program does not correctly calculate and print the area of a circle.");
        assertEquals(Double.parseDouble(getItemByName("circumference")), circumference, 0.001, "Your program does not correctly calculate and print the circumference of a circle.");
    }

}
