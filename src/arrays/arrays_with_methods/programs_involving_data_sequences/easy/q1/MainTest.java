package arrays.arrays_with_methods.programs_involving_data_sequences.easy.q1;

import global.BaseTest;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The average character is: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        AverageChar.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(new char[]{'a', 'c', 'd', 'z'}, 'i'),
                Arguments.of(new char[]{'f', '0', 'A', 'Z', '4'}, 'G'),
                Arguments.of(new char[]{'?', '!', 'E', 'z', '@', ' '}, '@'));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesAverageCharCorrectly(char[] input, char average) {
        char result = (char) MethodUtil.invokeIfMethodExists(AverageChar.class, "averageChar", new Object[]{input},
                char[].class);
        assertEquals(average, result, "Your method does not correctly computer the average character from a character array.");
    }
}
