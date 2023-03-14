package methods.using_methods.hard.q2;

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
        TestOption.defaultInput = "180.0";
        return new Clause[]{
                new StringLiteral("Please enter the angle in degrees:"),
                new NewLine(),
                new StringLiteral("The angle in radians is: "),
                new DoubleLiteral("angle")
        };
    }

    public void runMain() {
        Angles.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(0, 0.0), Arguments.of(180.0, 3.141592653589793),
                Arguments.of(-11.0, -0.19198621771937624), Arguments.of(287.0, 5.009094953223726),
                Arguments.of(256.791, 4.4818484394887586));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectOutput(double degrees, double radians) {
        runWithInput(String.valueOf(degrees));
        assertEquals(radians, Double.parseDouble(getItemByName("angle")), 0.00000000001,
                "Your program does not correctly convert and print the angle.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctDegreeCalcMethod(double degrees, double radians) throws Throwable {
        Object[][] arguments = {
                {degrees, double.class}
        };
        MethodTest m = new MethodTest(Angles.class, "degreeCalc", arguments);
        Object result = m.callMethod();
        CustomAssertions._assertEquals(radians, result, 0.00000000001, "Your degreeCalc method does not correctly convert the angle.");
    }

}
