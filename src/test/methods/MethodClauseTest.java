package test.methods;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import test.methods.MethodClause;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodClauseTest extends BaseTest {

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5.30";
        return new Clause[]{
                new StringLiteral("This is the main method\\."),
                new NewLine(),
                new StringLiteral("The sum of "),
                new IntegerLiteral("x"),
                new StringLiteral(" and "),
                new IntegerLiteral("y"),
                new StringLiteral(" is "),
                new IntegerLiteral("sum"),
                new NewLine(),
                new StringLiteral("Enter a double: "),
                new NewLine(),
                new StringLiteral("Calculating the area of a rectangle: "),
                new NewLine(),
                new StringLiteral("The area of the rectangle is: "),
                new DoubleLiteral("area")
        };
    }

    public void runMain() {
        MethodClause.main(new String[0]);
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of(0.00, 0.00),
                Arguments.of(1.5, 30.0),
                Arguments.of(3.14, 62.8)
        );
    }

    static Stream<Arguments> sumInputProvider() {
        return Stream.of(
                Arguments.of(4, 7, 11),
                Arguments.of(0, 0, 0),
                Arguments.of(-35, 35, 0),
                Arguments.of(497, -221, 276)
        );
    }

    static Stream<Arguments> areaInputProvider() {
        return Stream.of(
                Arguments.of(3.14, 2.84, 8.9176),
                Arguments.of(45.87, 124.92, 5730.0804),
                Arguments.of(4.2958, 0.00, 0.00)
        );
    }

    static Stream<Arguments> printMessageInputProvider() {
        return Stream.of(
                Arguments.of("Hello, how are you doing?", "Hello, how are you doing\\?"),
                Arguments.of("Hello world!", "Hello world!"),
                Arguments.of("[]-*?$", "\\[\\]\\-\\*\\?\\$")
        );
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    public void printsCorrectOutput(double x, double area) {
        runWithInput(String.valueOf(x));
        assertEquals(5, Integer.parseInt(getItemByName("x")),
                "Your program does not correctly print the first number that is being summed.");
        assertEquals(15, Integer.parseInt(getItemByName("y")),
                "Your program does not correctly print the second number that is being summed.");
        assertEquals(20, Integer.parseInt(getItemByName("sum")),
                "Your program does not print the correct sum.");
        assertEquals(area, Double.parseDouble(getItemByName("area")), 0.0001,
                "Your program does not correctly print the area.");
    }

    @ParameterizedTest
    @MethodSource("sumInputProvider")
    public void correctSumMethod(int x, int y, int sum) throws Throwable {
        Clause[] methodSentence = new Clause[]{
                new StringLiteral("The sum of "),
                new IntegerLiteral("x"),
                new StringLiteral(" and "),
                new IntegerLiteral("y"),
                new StringLiteral(" is "),
                new IntegerLiteral("sum"),
                new NewLine()
        };
        Object[][] arguments = {
                {x, int.class},
                {y, int.class}
        };
        MethodTest m = new MethodTest(MethodClause.class, "sum", arguments, methodSentence);
        Object output = m.callMethod();
        assertEquals(x, Integer.parseInt(m.getMethodItemByName("x")), "Your sum method does not correctly print the first input number.");
        assertEquals(y, Integer.parseInt(m.getMethodItemByName("y")), "Your sum method does not correctly print the second input number.");
        assertEquals(sum, Integer.parseInt(m.getMethodItemByName("sum")), "Your sum method does not correctly print the sum of the two input integers.");
        CustomAssertions._assertEquals(sum, output, "Your sum method does not correctly return the sum of the two input numbers.");
    }

    @ParameterizedTest
    @MethodSource("areaInputProvider")
    public void correctAreaMethod(double x, double y, double area) throws Throwable {
        Clause[] methodSentence = new Clause[]{
                new StringLiteral("Calculating the area of a rectangle: ")
        };
        Object[][] arguments = {
                {x, double.class},
                {y, double.class}
        };
        MethodTest m = new MethodTest(MethodClause.class, "area", arguments, methodSentence);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(area, output, 0.0001,
                "Your area method does not correctly calculate and return the area of a rectangle.");
    }

    @ParameterizedTest
    @MethodSource("printMessageInputProvider")
    public void correctPrintMessageMethod(String message, String expression) throws Throwable {
        Clause[] methodSentence = new Clause[]{
                new StringLiteral(expression)
        };
        Object[][] arguments = {
                {message, String.class}
        };
        MethodTest m = new MethodTest(MethodClause.class, "printMessage", arguments, methodSentence);
        m.callMethod();
    }

    @RepeatedTest(10)
    public void correctReturn15Method() throws Throwable {
        MethodTest m = new MethodTest(MethodClause.class, "return15");
        Object output = m.callMethod();
        CustomAssertions._assertEquals(15, output, "Your return15 method does not return the correct number.");
    }
}
