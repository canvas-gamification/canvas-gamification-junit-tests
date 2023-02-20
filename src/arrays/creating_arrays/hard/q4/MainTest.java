package arrays.creating_arrays.hard.q4;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    private static final int size = 50;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(ArrayUtil.generateRandomWordArray(size)) + (size - 2);
        return new Clause[]{
                new StringLiteral("Enter " + size + " names:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter an index:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("At index "),
                new IntegerLiteral("index"),
                new StringLiteral(": "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        RandomPickingNames.main(new String[0]);
    }

    public static String arrayToInput(String[] arr) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach((s) -> sb.append(s).append("\n"));
        return sb.toString();
    }

    static Stream<Arguments> inputProvider() {

        String[] one = ArrayUtil.generateRandomWordArray(size);
        String[] two = new String[size];
        String[] three = ArrayUtil.generateRandomWordArray(size);
        for(int x = 0; x < size; x++){
            one[x] += " plus other words in row";
            two[x] = " ";
            three[x] += "7@!00";
        }

        return Stream.of(
                Arguments.of(ArrayUtil.generateRandomWordArray(size), 0),
                Arguments.of(ArrayUtil.generateRandomWordArray(size), 1),
                Arguments.of(ArrayUtil.generateRandomWordArray(size), 7),
                Arguments.of(ArrayUtil.generateRandomWordArray(size), size-1),
                Arguments.of(one, size-5),
                Arguments.of(two, 3),
                Arguments.of(three, size-2)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void picksRandomNameCorrectly(String[] in, int c) throws InvalidClauseException {
        runWithInput(arrayToInput(in) + c, new Clause[]{
                new StringLiteral(in[c], "name")
        });

        assertEquals(c, Integer.parseInt(getItemByName("index")), "Your program does not print the input index.");
        assertEquals(in[c], getItemByName("name"), "Your program does not print the correct name located at the given index.");
    }
}
