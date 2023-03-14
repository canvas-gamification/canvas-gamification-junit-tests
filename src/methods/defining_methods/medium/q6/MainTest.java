package methods.defining_methods.medium.q6;

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
        TestOption.defaultInput = "27";
        return new Clause[]{
                new StringLiteral("Please enter the volume of a cube: "),
                new NewLine(),
                new StringLiteral("The side length of the given cube is: "),
                new DoubleLiteral("side")
        };
    }

    public void runMain() {
        VolToLength.main(new String[0]);
    }

    static Stream<Arguments> lengthCubeInputProvider() {
        return Stream.of(
                Arguments.of(64, 4.0),
                Arguments.of(45.9, 3.5804495757820107),
                Arguments.of(1234567, 107.27657218553581),
                Arguments.of(-27, -1.0),
                Arguments.of(1, 1.0),
                Arguments.of(0.75, 0.9085602964160698),
                Arguments.of(-0.0001, -1.0));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(Arguments.of("25", 2.924017738212866), Arguments.of("2.5", 1.3572088082974532), Arguments.of("-34", -1.0));
    }

    @ParameterizedTest
    @MethodSource("lengthCubeInputProvider")
    void correctLengthCubeMethod(double in, double side) throws Throwable {
        Object[][] arguments = {
                {in, double.class}
        };
        MethodTest m = new MethodTest(VolToLength.class, "lengthCube", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(side, output, 0.00001, "Your lengthCube method does not correctly calculate the side length of a cube based on the volume.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, double side) {
        runWithInput(in);
        assertEquals(side, Double.parseDouble(getItemByName("side")), 0.00001, "Your program does not print the correct side length.");
    }
}
