package arrays.arrays_with_methods.medium.q8;

import global.MethodTest;
import global.tools.CustomAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest {
    // Parsons

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(0, 's', new char[][]{}),
                Arguments.of(1, '@', new char[][]{{'@'}}),
                Arguments.of(2, '#', new char[][]{{' ', '#'}, {'#', '#'}}),
                Arguments.of(5, '9', new char[][]{
                        {' ', ' ', ' ', ' ', '9'},
                        {' ', ' ', ' ', '9', '9'},
                        {' ', ' ', '9', '9', '9'},
                        {' ', '9', '9', '9', '9'},
                        {'9', '9', '9', '9', '9'}
                }),
                Arguments.of(10, '*', new char[][]{
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*'},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*'},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*'},
                        {' ', ' ', ' ', ' ', ' ', ' ', '*', '*', '*', '*'},
                        {' ', ' ', ' ', ' ', ' ', '*', '*', '*', '*', '*'},
                        {' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*'},
                        {' ', ' ', ' ', '*', '*', '*', '*', '*', '*', '*'},
                        {' ', ' ', '*', '*', '*', '*', '*', '*', '*', '*'},
                        {' ', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                        {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'}
                })
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctMapThePatternMethod(int n, char c, char[][] arr) throws Throwable {
        Object[][] arguments = {
                {n, int.class},
                {c, char.class}
        };
        MethodTest m = new MethodTest(PatternMaker.class, "mapThePattern", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(arr, output, "Your mapThePattern method does not correctly generate the pattern for the specified character.");
    }
}
