package methods.using_methods.hard.q2;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "180";
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
        return Stream.of(Arguments.of(0, 0.0), Arguments.of(180, 3.141592653589793),
                Arguments.of(-11, -0.19198621771937624), Arguments.of(287, 5.009094953223726));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectOutput(int degrees, double radians) {
        runWithInput(String.valueOf(degrees));
        assertEquals(Double.parseDouble(getItemByName("angle")), radians, 0.00000000001,
                "Your program does not correctly convert an angle from degrees to radians.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctDegreeCalcMethod(int degrees, double radians) {
        String failMessage = "Your program does not have a method for converting an angle from degrees to radians.";
        double result = (double) invokeIfMethodExists(Angles.class, "degreeCalc", failMessage, new Object[]{degrees}, int.class);
        assertEquals(result, radians, 0.00000000001, "Your method does not correctly convert an angle from degrees to radians.");
    }

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName, String failMessage, Object[] arguments, Class<?>... methodArgumentTypes) {
        try {
            Method m = methodClass.getMethod(methodName, methodArgumentTypes);
            return m.invoke(null, arguments);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            fail(failMessage);
            return null;
        }
    }
}
