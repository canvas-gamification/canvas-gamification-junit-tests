package arrays.programs_involving_data_sequences.easy.q8;

import global.BaseTest;
import global.MethodTest;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new IntegerLiteral(4),
                new NewLine(),
                new IntegerLiteral(4),
                new NewLine(),
                new IntegerLiteral(2),
                new NewLine(),
                new IntegerLiteral(10)
        };
    }

    public void runMain() {
        SuperCali.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(ArrayUtil.generateRandomWordArray(5), 5),
                Arguments.of(ArrayUtil.generateRandomWordArray(10), 10),
                Arguments.of(ArrayUtil.generateRandomWordArray(15), 15),
                Arguments.of(ArrayUtil.generateRandomWordArray(7), 7),
                Arguments.of(ArrayUtil.generateRandomWordArray(20), 20),
                Arguments.of(ArrayUtil.generateRandomWordArray(50), 50),
                Arguments.of(ArrayUtil.generateRandomWordArray(100), 100),
                Arguments.of(new String[]{"word", "dress", "longest", "also", "longest"}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctLengthFinderMethod(String[] arr, int size) throws Throwable {
        Clause[] methodSentence = clauseBuilder(size);

        Object[][] arguments = {
                {arr, String[].class}
        };

        int indexOf = -1;
        int longest = -1;
        for (int x = 0; x < size; x++) {
            if (arr[x].length() > longest) {
                longest = arr[x].length();
                indexOf = x;
            }
        }

        MethodTest m = new MethodTest(SuperCali.class, "lengthFinder", arguments, methodSentence);
        m.callMethod();

        for (int x = 0; x < size; x++) {
            if (x == indexOf) {
                assertEquals(longest, Integer.parseInt(m.getMethodItemByName("num " + x)), "Your method does not print the correct word lengths.");
                continue;
            }

            assertEquals(arr[x].length(), Integer.parseInt(m.getMethodItemByName("num " + x)), "Your method does not print the correct word lengths.");
        }

        assertTrue(Arrays.asList(arr).contains("Supercalifragilisticexpialidocious"), "Your method does not substitute one element for the specified word.");
        assertEquals("Supercalifragilisticexpialidocious", arr[indexOf], "Your method does not replace the longest word with Supercalifragilisticexpialidocious.");
    }

    public Clause[] clauseBuilder(int size) {
        Clause[] c = new Clause[size * 2];
        int count = 0;

        for (int x = 0; x < size; x++) {
            c[count++] = new IntegerLiteral("num " + x);
            c[count++] = new NewLine();
        }

        return c;
    }

}
