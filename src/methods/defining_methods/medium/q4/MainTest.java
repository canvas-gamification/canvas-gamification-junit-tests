package methods.defining_methods.medium.q4;

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
        TestOption.defaultInput = "2.9 8";
        return new Clause[]{
                new StringLiteral("Please enter the height of the cylinder: "),
                new NewLine(),
                new StringLiteral("Please enter the radius of the cylinder: "),
                new NewLine(),
                new StringLiteral("The volume of the given cylinder is: "),
                new DoubleLiteral("volume")
        };
    }

    public void runMain() {
        CylinderTime.main(new String[0]);
    }

    static Stream<Arguments> volumeCylinderInputProvider() {
        return Stream.of(
                Arguments.of(3, 3, 84.82300164692441),
                Arguments.of(6.8, 2, 290.5344886039841),
                Arguments.of(2, 4.6, 57.805304826052186),
                Arguments.of(4.1, 10.9, 575.630880324604),
                Arguments.of(0.4, 0.7, 0.3518583772020568),
                Arguments.of(260, 841, 1.7860456890482548E8),
                Arguments.of(-24, 12, -1),
                Arguments.of(4.7, -1.2, -1),
                Arguments.of(-3, -2.2, -1)
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("6 4", 452.3893421169302),
                Arguments.of("2.2 5.1", 77.54707306121047),
                Arguments.of("-4 78", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("volumeCylinderInputProvider")
    void correctVolumeCylinderMethod(double h, double r, double vol) throws Throwable {
        Object[][] arguments = {
                {h, double.class},
                {r, double.class}
        };
        MethodTest m = new MethodTest(CylinderTime.class, "volumeCylinder", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(vol, output, 0.00001, "Your volumeCylinder method does not correctly calculate the volume.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, double vol) {
        runWithInput(in);
        assertEquals(vol, Double.parseDouble(getItemByName("volume")), 0.00001, "Your program does not print the correct volume.");
    }
}
