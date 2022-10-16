package test.methods;

import global.BaseRandomTest;
import global.MethodTest;
import global.variables.Clause;
import global.variables.clauses.RandomChar;
import global.variables.clauses.RandomDouble;
import global.variables.clauses.RandomInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MethodRandomTestCode extends BaseRandomTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new RandomInteger(0, 20)
        };
    }

    public void runMain() {
        MethodRandomCode.main(new String[0]);
    }

    static Stream<Integer> randomIntInputProvider() {
        return Stream.of(
                1,
                40,
                35,
                26
        );
    }


    static Stream<Double> randomDoubleInputProvider() {
        return Stream.of(
                1.56,
                3.1415926,
                49783.231,
                45.0,
                0.01
        );
    }

    static Stream<Character> randomCharInputProvider() {
        return Stream.of(
                'a',
                'e',
                'z',
                'q',
                'o'
        );
    }

    static Stream<Arguments> randomDoubleArrayInputProvider() {
        return Stream.of(
                Arguments.of(1.56, 100),
                Arguments.of(3.1415926, 68),
                Arguments.of(49783.231, 836),
                Arguments.of(45.0, 15),
                Arguments.of(0.01, 1234)
        );
    }

    @ParameterizedTest
    @MethodSource("randomIntInputProvider")
    public void correctRandomIntMethod(int i) throws Throwable {
        Object[][] args = {{i, int.class}};
        MethodTest m = new MethodTest(MethodRandomCode.class, "randomInt", args);
        m.checkRandom(new RandomInteger(0, i));
    }

    @ParameterizedTest
    @MethodSource("randomDoubleInputProvider")
    public void correctRandomDoubleMethod(double d) throws Throwable {
        Object[][] args = {{d, double.class}};
        MethodTest m = new MethodTest(MethodRandomCode.class, "randomDouble", args);
        m.checkRandom(new RandomDouble(0, d));
    }

    @ParameterizedTest
    @MethodSource("randomCharInputProvider")
    public void correctRandomCharMethod(char c) throws Throwable {
        Object[][] args = {{c, char.class}};
        MethodTest m = new MethodTest(MethodRandomCode.class, "randomChar", args);
        m.checkRandom(new RandomChar('a', c, true));
    }

    @ParameterizedTest
    @MethodSource("randomIntInputProvider")
    public void correctRandomIntArrayMethod(int i) throws Throwable {
        Object[][] args = {{i, int.class}};
        MethodTest m = new MethodTest(MethodRandomCode.class, "randomIntArray", args);
        m.checkRandom(new RandomInteger(0, i));
    }

    @ParameterizedTest
    @MethodSource("randomDoubleArrayInputProvider")
    public void correctRandomDoubleArrayMethod(double d, int size) throws Throwable {
        Object[][] args = {
                {d, double.class},
                {size, int.class}
        };
        MethodTest methodTest = new MethodTest(MethodRandomCode.class, "randomDoubleArray", args);
        methodTest.checkRandom(new RandomDouble(0, d));
    }

}
