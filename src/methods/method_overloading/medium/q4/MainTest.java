package methods.method_overloading.medium.q4;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.tools.CustomAssertions;

public class MainTest {

    // Parsons
    static Stream<Arguments> inputThreeIntegersProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3, 2.0),
                Arguments.of(1, 0, 2, 1.0),
                Arguments.of(0, 1, 2, 1.0),
                Arguments.of(-2, 0, 2, 0.0),
                Arguments.of(0, -2, 2, 0.0),
                Arguments.of(1002, 2124, 963, 1363.0));
    }

    static Stream<Arguments> inputThreeDoublesProvider() {
        return Stream.of(
                Arguments.of(1.2, 2.123, 222.0, 75.1077),
                Arguments.of(1.122, -1231.6, 51.22, -393.086),
                Arguments.of(0.0, 0.0, 0.0, 0.0),
                Arguments.of(1.0, 2.0, 3.0, 2.0),
                Arguments.of(1.0, 0.0, 2.0, 1.0));
    }

    @ParameterizedTest
    @MethodSource("inputThreeIntegersProvider")
    void correctsThreeIntegersAverage(int a, int b, int c, double avg) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class},
                {c, int.class}
        };
        MethodTest m = new MethodTest(AveOfThree.class, "average", arguments);
        Object output = m.callMethod();
        String errMsg = "Your average() method does not return the correct average for three integers";
        CustomAssertions._assertEquals(avg, output, 0.0001, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputThreeDoublesProvider")
    void correctsThreeDoublesAverage(double a, double b, double c, double avg) throws Throwable {
        Object[][] arguments = {
                {a, double.class},
                {b, double.class},
                {c, double.class}
        };
        MethodTest m = new MethodTest(AveOfThree.class, "average", arguments);
        Object output = m.callMethod();
        String errMsg = "Your average() method does not return the correct average for three doubles";
        CustomAssertions._assertEquals(avg, output, 0.0001, errMsg);
    }
}
