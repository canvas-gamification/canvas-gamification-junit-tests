package methods.method_overloading.medium.q8;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.tools.CustomAssertions;

public class MainTest {
    // Parsons

    static Stream<Arguments> inputTwoCharsProvider() {
        return Stream.of(
                Arguments.of('a', 'b', 'b'),
                Arguments.of('(', 'a', 'a'),
                Arguments.of('(', '?', '?'),
                Arguments.of('0', '1', '1'),
                Arguments.of('Z', 'a', 'a'),
                Arguments.of('Z', '0', 'Z'),
                Arguments.of('z', 'a', 'z'));
    }

    static Stream<Arguments> inputThreeIntsProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3, 3),
                Arguments.of(23, 22, -123, 23),
                Arguments.of(0, 0, 0, 0),
                Arguments.of(0, 1, 2, 2),
                Arguments.of(0, -1, -2, 0),
                Arguments.of(-1, -2, -3, -1));
    }

    @ParameterizedTest
    @MethodSource("inputTwoCharsProvider")
    void correctGreatestMethod(char a, char b, char greater) throws Throwable {
        Object[][] arguments = {
                {a, char.class},
                {b, char.class}
        };
        MethodTest m = new MethodTest(OverloadChar.class, "greatest", arguments);
        Object output = m.callMethod();
        String errMsg = "Your greatest method for two characters does not return the greater character.";
        CustomAssertions._assertEquals(greater, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputThreeIntsProvider")
    void correctGreatestMethod(int a, int b, int c, int greatest) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class},
                {c, int.class}
        };
        MethodTest m = new MethodTest(OverloadChar.class, "greatest", arguments);
        Object output = m.callMethod();
        String errMsg = "Your greatest method for three integers does not return the greatest character.";
        CustomAssertions._assertEquals(greatest, output, errMsg);
    }
}
