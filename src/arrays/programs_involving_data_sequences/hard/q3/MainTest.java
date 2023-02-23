package arrays.programs_involving_data_sequences.hard.q3;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    /**
     * The number of characters the student's code should take as input
     */
    private static final int numChars = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray('a', 'z', numChars)) + "2 " + "7 ";
        return new Clause[]{
                new StringLiteral("Enter the character array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter the starting index:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter the ending index:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Your string is:"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        SubThat.main(new String[0]);
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(new char[]{'a', 'p', 'p', 'l', 'e', 'i', 's', 'b', 'a', 'd'}, 0, 4, "appl"),
                Arguments.of(new char[]{'h', 'f', 'j', 'z', 'w'}, 0, 8, ""),
                Arguments.of(new char[]{}, 0, 4, ""),
                Arguments.of(new char[]{'a', 'z', 'x', 'w', 'q', 's', 'p', 'e', 'f', 'e', 'e', 'g', 'k', 'z', 'a', 'e'}, 5, 4, ""),
                Arguments.of(new char[]{'a', 'b', 'c', 'd', 'z', 'g', 'l'}, 4, 4, ""),
                Arguments.of(new char[]{'f', 'd', 'z', 'q', 'e', 't', 'y', 'p', 'e', 'z', 'w', 'z', 'm', 'n'}, 7, 14, "pezwzmn"),
                Arguments.of(ArrayUtil.generateRandomArray('a', 'z', 39), -1, 3, ""),
                Arguments.of(ArrayUtil.generateRandomArray('a', 'q', 18), 4, -1, ""),
                Arguments.of(ArrayUtil.generateRandomArray('a', 'x', 27), -13, -2, "")
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        Random r = new Random();
        return Stream.of(
                Arguments.of(ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray('a', (char) ('z' + 1), numChars)), numChars / 2, numChars),
                Arguments.of(ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray('a', (char) ('z' + 1), numChars)), 0, numChars),
                Arguments.of(ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray('a', (char) ('z' + 1), numChars)), numChars - 1, numChars + 1),
                Arguments.of(ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray('a', 'z', numChars)), numChars - 1, numChars),
                Arguments.of(ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray('a', (char) ('z' + 1), numChars)), 6, 5),
                Arguments.of(ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray('a', (char) ('z' + 1), numChars)), -1, 5),
                Arguments.of(ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray('a', (char) ('z' + 1), numChars)), r.nextInt(numChars), r.nextInt(numChars)));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctSubCharacterStringMethod(char[] input, int start, int end, String subString) throws Throwable {
        TestOption.incorrectStructureErrorMessage = "Your SubCharacterString method should not print anything to the console.";
        Object[][] arguments = {
                {input, char[].class},
                {start, int.class},
                {end, int.class}
        };
        MethodTest m = new MethodTest(SubThat.class, "subCharacterString", arguments, methodSentence);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(subString, output, "Your SubCharacterString method does not generate the correct substring based on the inputs provided.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsCorrectOutput(String charInput, int startIndex, int endIndex) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the substring correctly.";
        String output = "";
        if (startIndex < endIndex && startIndex >= 0 && endIndex <= numChars)
            output = charInput.replaceAll(" ", "").substring(startIndex, endIndex);
        runWithInput(charInput + startIndex + " " + endIndex, new Clause[]{
                new StringLiteral(output)
        });
    }
}
