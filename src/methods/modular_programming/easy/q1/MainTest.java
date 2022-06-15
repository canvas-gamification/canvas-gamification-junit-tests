package methods.modular_programming.easy.q1;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.Logger;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "170.0";
        return new Clause[]{
                new StringLiteral("Please enter your height in cm: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        AverageHeight.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(170.0, "You're above the average height in Canada!"),
                Arguments.of(168.7, "You're below the average height in Canada!"),
                Arguments.of(168.71, "You're above the average height in Canada!"),
                Arguments.of(-37, "Invalid height input!"), Arguments.of(149.23716, "You're below the average height in Canada!"),
                Arguments.of(-0.0001, "Invalid height input!"));
    }

    static Stream<Double> inputProviderDouble(){
        return Stream.of(170.0, 168.7, -37.00, 11.00, 87.345, -13.67);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctHeightCheckerMethod(double height, String message) throws InvalidClauseException {
    }

    @ParameterizedTest
    @MethodSource("inputProviderDouble")
    void correctUserInputMethod(){

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
