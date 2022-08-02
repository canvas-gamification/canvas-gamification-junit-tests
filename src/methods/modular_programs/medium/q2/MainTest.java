package methods.modular_programs.medium.q2;

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
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "80";
        return new Clause[]{
                new StringLiteral("Enter the temperature in Fahrenheit: "),
                new NewLine(),
                new StringLiteral("The temperature in Celsius is "),
                new DoubleLiteral("temp")
        };
    }

    public void runMain() {
        TempConverter.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(0, -17.77777777777778),
                Arguments.of(-40.0, -40.0),
                Arguments.of(86.0, 30),
                Arguments.of(32, 0),
                Arguments.of(-459.67, -273.15)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctTempConverterMethod(double fahrenheit, double celsius ) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(TempConverter.class, "tempConversion",
                new Object[]{fahrenheit}, double.class);
        CustomAssertions._assertEquals(celsius, output, 0.00000001, "Your tempConverter method does not correctly convert the temperature.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsOutputCorrectly(double fahrenheit, double celsius) {
        runWithInput(String.valueOf(fahrenheit));
        assertEquals(celsius, Double.parseDouble(getItemByName("temp")), 0.00000001, "Your program does not correctly convert and print the temperature.");
    }

}
