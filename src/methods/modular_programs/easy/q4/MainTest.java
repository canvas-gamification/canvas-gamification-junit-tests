package methods.modular_programs.easy.q4;

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
        TestOption.defaultInput = "345.32 1.2345 2.3";
        return new Clause[]{
                new StringLiteral("Enter the first number: "),
                new NewLine(),
                new StringLiteral("Enter the second number: "),
                new NewLine(),
                new StringLiteral("Enter the third number: "),
                new NewLine(),
                new StringLiteral("The values after the decimal point for the first variable are "),
                new DoubleLiteral("first"),
                new NewLine(),
                new StringLiteral("The values after the decimal point for the second variable are "),
                new DoubleLiteral("second"),
                new NewLine(),
                new StringLiteral("The values after the decimal point for the third variable are "),
                new DoubleLiteral("third")
        };
    }

    public void runMain(){ReturnChange.main(new String[0]);}

    static Stream<Arguments> valueAfterCalcInputProvider(){
        return Stream.of(Arguments.of(3.1, 0.1), Arguments.of(67.2175396, 0.2175396), Arguments.of(0.34, 0.34), Arguments.of(0.0, 0.0), Arguments.of(-12.523, -0.523), Arguments.of(0.1, 0.1), Arguments.of(-0.1, -0.1));
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(Arguments.of("5.78 3.2 12743.867", 0.78, 0.2, 0.867), Arguments.of("-34.213 -56.34 91.2", -0.213, -0.34, 0.2), Arguments.of("0.56 0.1 0.853245", 0.56, 0.1, 0.853245), Arguments.of("0.0 0.1 1.1", 0.0, 0.1, 0.1));
    }

    @ParameterizedTest
    @MethodSource("valueAfterCalcInputProvider")
    void correctValueAfterCalcMethod(double in, double decimals) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(ReturnChange.class, "valueAfterCalc", new Object[]{in}, double.class);
        CustomAssertions._assertEquals(decimals, output, 0.1, "Your valueAfterCalc method does not correctly calculate the decimal values.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, double d1, double d2, double d3){
        runWithInput(in);
        assertEquals(d1, Double.parseDouble(getItemByName("first")), 0.1, "Your program does not correctly display the first set of values.");
        assertEquals(d2, Double.parseDouble(getItemByName("second")), 0.1, "Your program does not correctly display the second set of values.");
        assertEquals(d3, Double.parseDouble(getItemByName("third")), 0.1, "Your program does not correctly display the third set of values.");
    }
}
