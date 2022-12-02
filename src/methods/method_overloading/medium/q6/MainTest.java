package methods.method_overloading.medium.q6;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.tools.CustomAssertions;

public class MainTest {
    // Parsons

    static Stream<Arguments> inputDoubleFloatProvider() {
        return Stream.of(
                Arguments.of(1.0, 2.0, 0.5),
                Arguments.of(2.0, 1.0, 2.0),
                Arguments.of(1.0, 1.0, 1.0),
                Arguments.of(0.0, 1.0, 0.0),
                Arguments.of(2.55, 222.123, 0.01148),
                Arguments.of(222.123, -2.55, -87.1071));
    }

    static Stream<Arguments> inputIntLongProvider() {
        return Stream.of(
                Arguments.of(1, 2, 0.0),
                Arguments.of(2, 1, 2.0),
                Arguments.of(1, 1, 1.0),
                Arguments.of(0, 1, 0.0),
                Arguments.of(2, 222, 0.0),
                Arguments.of(222, -2, -111.0));
    }

    @ParameterizedTest
    @MethodSource("inputDoubleFloatProvider")
    void correctDoubleFloatDivideMethod(double a, double b, double divide) throws Throwable {
        Object[][] arguments = {
                {a, double.class},
                {(float) b, float.class}
        };
        MethodTest m = new MethodTest(OverloadFloat.class, "divide", arguments);
        Object output = m.callMethod();
        String errMsg = "Your divide method does not return the correct value after double and float division.";
        CustomAssertions._assertEquals(divide, output, 0.0001, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputIntLongProvider")
    void correctIntLongDivideMethod(int a, long b, double divide) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, long.class}
        };
        MethodTest m = new MethodTest(OverloadFloat.class, "divide", arguments);
        Object output = m.callMethod();
        String errMsg = "Your divide method does not return the correct value after int and long division.";
        CustomAssertions._assertEquals(divide, output, 0.0001, errMsg);
    }
}
