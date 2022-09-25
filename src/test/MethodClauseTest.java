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
        MethodTest m = new MethodTest(MethodClause.class, "print", new Object[]{s}, new Class[]{String.class},
                new Clause[]{new StringLiteral(s)});
        m.invokeIfMethodExists();
    }

    @ParameterizedTest
    @MethodSource("addInputProvider")
    void correctAddMethod(int x, int y, int z) throws Throwable {
        MethodTest m = new MethodTest(MethodClause.class, "add", new Object[]{x, y},
                new Class[]{int.class, int.class});
        Object output = m.invokeIfMethodExists();
        CustomAssertions._assertEquals(z, output, "Your add method does not correctly add two numbers.");
    }

    @ParameterizedTest
    @MethodSource("areaCalcInputProvider")
    void correctAreaMethod(double x, double y, double area) throws Throwable {
        MethodTest m = new MethodTest(MethodClause.class, "areaCalc", new Object[]{x, y},
                new Class[]{double.class, double.class}, new Clause[]{
                new StringLiteral("The area is "),
                new DoubleLiteral("area")
        });
        //TestOption.incorrectMethodStructureErrorMessage = "Your areaCalc method does not correctly print out the area.";
        Object output = m.invokeIfMethodExists();
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
        m.setMethodNotFoundErrorMessage("Test ");
        Object output = m.invokeIfMethodExists();
        Logger.logMessage(m.getMethodOutput());
        assertEquals(35, Integer.parseInt(m.getMethodItemByName("integer")), "ints were different");
        assertEquals(34.124, Double.parseDouble(m.getMethodItemByName("double")), "double diff");
        CustomAssertions._assertEquals(69, output, "method output incorrect");
    }
}
