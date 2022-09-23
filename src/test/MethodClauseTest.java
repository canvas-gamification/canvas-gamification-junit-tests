package test;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MethodClauseTest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The sum of two numbers is: "),
                new IntegerLiteral("sum"),
//                new NewLine(),
//                new StringLiteral("The area is "),
//                new DoubleLiteral("area")
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

    static Stream<Arguments> areaCalcInputProvider(){
        return Stream.of(
                Arguments.of(4.5, 3.9, 17.55),
                Arguments.of(3, 5, 15.0)
        );
    }

    @ParameterizedTest
    @MethodSource("printInputProvider")
    void correctPrintMethod(String s) throws Throwable {
        TestOption.methodTestSentence = new Clause[]{
                new StringLiteral(s)
        };
        MethodUtil.invokeIfMethodExists(MethodClause.class, "print", new Object[]{s}, String.class);
    }

    @ParameterizedTest
    @MethodSource("addInputProvider")
    void correctAddMethod(int x, int y, int z) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(MethodClause.class, "add", new Object[]{x, y},
                int.class, int.class);
        CustomAssertions._assertEquals(z, output, "Your add method does not correctly add two numbers.");
    }

    @ParameterizedTest
    @MethodSource("areaCalcInputProvider")
    void correctAreaMethod(double x, double y, double area) throws Throwable {
        TestOption.methodTestSentence = new Clause[]{
                new StringLiteral("The area is "),
                new DoubleLiteral("area")
        };
        TestOption.incorrectMethodStructureErrorMessage = "Your areaCalc method does not correctly print out the area.";
        Object output = MethodUtil.invokeIfMethodExists(MethodClause.class, "areaCalc", new Object[]{x, y},
                double.class, double.class);
        CustomAssertions._assertEquals(area, output, "Your area method does not correctly calculate area.");
    }
}
