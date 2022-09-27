package test;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.Logger;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodClauseTest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The sum of two numbers is: "),
                new IntegerLiteral("sum"),
                new NewLine(),
                new StringLiteral("The area is "),
                new DoubleLiteral("area")
        };
    }

    public void runMain() {
        MethodClause.main(new String[0]);
    }

    static Stream<String> printInputProvider() {
        return Stream.of(
                "Hello",
                "Goodbye",
                "Dance till you can no longer insurrectionary"
        );
    }

    static Stream<Arguments> addInputProvider() {
        return Stream.of(
                Arguments.of(3, 6, 9),
                Arguments.of(11, 14, 25)
        );
    }

    static Stream<Arguments> areaCalcInputProvider() {
        return Stream.of(
                Arguments.of(4.5, 3.9, 17.55),
                Arguments.of(3, 5, 15.0)
        );
    }

    @ParameterizedTest
    @MethodSource("printInputProvider")
    void correctPrintMethod(String s) throws Throwable {
        Object[][] arguments = {
                {s, String.class}
        };
        Clause[] c = new Clause[]{new StringLiteral(s)};
        MethodTest m = new MethodTest(MethodClause.class, "print", arguments, c);
        m.callMethod();
    }

    @ParameterizedTest
    @MethodSource("addInputProvider")
    void correctAddMethod(int x, int y, int z) throws Throwable {
        Object[][] arguments = {
                {x, int.class},
                {y, int.class}
        };
        MethodTest m = new MethodTest(MethodClause.class, "add", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(z, output, "Your add method does not correctly add two numbers.");
    }

    @ParameterizedTest
    @MethodSource("areaCalcInputProvider")
    void correctAreaMethod(double x, double y, double area) throws Throwable {
        Object[][] arguments = {
                {x, double.class},
                {y, double.class}
        };
        Clause[] c = new Clause[]{
                new StringLiteral("The area is "),
                new DoubleLiteral("area")
        };
        MethodTest m = new MethodTest(MethodClause.class, "areaCalc", arguments, c);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(area, output, "Your area method does not correctly calculate area.");
    }

    @Test
    void testTestMethod() throws Throwable {
        Clause[] c = new Clause[]{
                new IntegerLiteral("integer"),
                new NewLine(),
                new StringLiteral("Hello world"),
                new NewLine(),
                new DoubleLiteral(30, 35, "double")
        };
        MethodTest m = new MethodTest(MethodClause.class, "testMethod", c, "Your double value is outside the range.");
        /*
            setMethodNotFoundErrorMessage can be used to specify a custom error message if MethodTest is unable to find
            the specified method in the class. There is also a default message which specifies to the user that the method
            could not be found.
         */
        m.setMethodNotFoundErrorMessage("Unable to find the method named testMethod in your program. Please make sure to check your method name.");
        Object output = m.callMethod();
        /*
            getMethodItemByName can be used to retrieve the values captured by the clause with the specified name. This
            value can then be used in an assertEquals to check if the method printed the correct value.
         */
        assertEquals(35, Integer.parseInt(m.getMethodItemByName("integer")), "Your testMethod did not print the correct integer value.");
        assertEquals(34.124, Double.parseDouble(m.getMethodItemByName("double")), "Your testMethod did not print the correct double value.");
        CustomAssertions._assertEquals(69, output, "Your testMethod method returned the incorrect value.");
    }
}
