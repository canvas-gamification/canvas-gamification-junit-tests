package methods.using_methods.hard.q7;

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
        TestOption.defaultInput = "4.5";
        return new Clause[]{
                new StringLiteral("Please enter the length of a side:"),
                new NewLine(),
                new StringLiteral("The volume of the cube is "),
                new DoubleLiteral("volume")
        };
    }

    public void runMain() {
        VolumeOfCube.main(new String[0]);
    }

    static Stream<Arguments> cubeVolumeInputProvider() {
        return Stream.of(Arguments.of(0, 0.0), Arguments.of(1, 1.0), Arguments.of(-1.0, -1.0), Arguments.of(-6.0, -1.0), Arguments.of(-23.8, -1.0), Arguments.of(25.5, 16581.375), Arguments.of(5945.8, 2.1019911829991202E11), Arguments.of(0.34, 0.039304));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(Arguments.of("3.3", 35.937), Arguments.of("56789", 1.83143986697069E14), Arguments.of("-2.7", -1.0));
    }

    @ParameterizedTest
    @MethodSource("cubeVolumeInputProvider")
    void correctCubeVolumeMethod(double in, double vol) throws Throwable {
        Object[][] arguments = {
                {in, double.class}
        };
        MethodTest m = new MethodTest(VolumeOfCube.class, "cubeVolume", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(vol, output, 0.00001, "Your cubeVolume method does not correctly calculate the volume for the given length.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, double vol) {
        runWithInput(in);
        assertEquals(vol, Double.parseDouble(getItemByName("volume")), 0.00001, "Your program does not correctly calculate and print the volume of a cube.");
    }
}
