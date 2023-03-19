package methods.using_methods.hard.q6;

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
        TestOption.defaultInput = "9.7";
        return new Clause[]{
                new StringLiteral("Please enter the radius of the sphere:"),
                new NewLine(),
                new StringLiteral("The volume of the sphere is "),
                new DoubleLiteral("volume")
        };
    }

    public void runMain() {
        VolumeOfSphere.main(new String[0]);
    }

    static Stream<Arguments> sphereVolumeInputProvider() {
        return Stream.of(Arguments.of(0, 0.0), Arguments.of(-5.0, -1.0), Arguments.of(-1.0, -1.0), Arguments.of(-13.9, -1.0), Arguments.of(1, 4.1887902047863905), Arguments.of(10000, 4.1887902047863906E12), Arguments.of(125, 8181230.868723419), Arguments.of(23.6, 55058.53078200475));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(Arguments.of("2.67", 79.73011553070754), Arguments.of("89.999", 3053526.272818271), Arguments.of("2571.67", 7.124170834478906E10), Arguments.of("-134.2", -1.0));
    }

    @ParameterizedTest
    @MethodSource("sphereVolumeInputProvider")
    void correctSphereVolumeMethod(double in, double vol) throws Throwable {
        Object[][] arguments = {
                {in, double.class}
        };
        MethodTest m = new MethodTest(VolumeOfSphere.class, "sphereVolume", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(vol, output, 0.000001, "Your method sphereVolume does not calculate volume correctly.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsCorrectOutput(String in, double vol) {
        runWithInput(in);
        assertEquals(vol, Double.parseDouble(getItemByName("volume")), 0.000001, "Your program does not correctly output the volume for the given radius.");
    }
}
