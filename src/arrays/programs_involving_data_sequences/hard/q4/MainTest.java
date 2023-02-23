package arrays.programs_involving_data_sequences.hard.q4;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java
    private static final int inputLength = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Hello how are you today this is my test sentence 5";
        return new Clause[]{
                new StringLiteral("Enter words for the array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter an index:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        StringSlice.main(new String[0]);
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(new String[]{"word", "new", "york", "knight", "night", "height", "fight", "flight"}, 5, new String[]{"height", "fight", "flight"}),
                Arguments.of(new String[]{"World", "NASA", "Coffee", "glass", "boat", "king"}, 6, new String[]{"World", "NASA", "Coffee", "glass", "boat", "king"}),
                Arguments.of(new String[]{"Hello", "World!", "How", "are", "you", "this", "fine", "summer", "day"}, -11, new String[]{"Hello", "World!", "How", "are", "you", "this", "fine", "summer", "day"}),
                Arguments.of(new String[]{"Hi", "how", "are", "ya"}, -1, new String[]{"Hi", "how", "are", "ya"}),
                Arguments.of(new String[]{"cheese", "intelligent", "farmer", "pork", "dragon", "dawn"}, 0, new String[]{"cheese", "intelligent", "farmer", "pork", "dragon", "dawn"}),
                Arguments.of(new String[]{"eagle", "muggle", "johnson", "tea", "tip", "hedge", "sword", "penguin", "picture", "spicy"}, 10, new String[]{"eagle", "muggle", "johnson", "tea", "tip", "hedge", "sword", "penguin", "picture", "spicy"}),
                Arguments.of(new String[]{"why", "am", "I", "still", "getting", "shielded"}, 5, new String[]{"shielded"}),
                Arguments.of(new String[0], 0, new String[0])
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of(ArrayUtil.generateRandomWordArray(inputLength), inputLength / 2),
                Arguments.of(ArrayUtil.generateRandomWordArray(inputLength), inputLength),
                Arguments.of(ArrayUtil.generateRandomWordArray(inputLength), inputLength - 1),
                Arguments.of(ArrayUtil.generateRandomWordArray(inputLength), -1),
                Arguments.of(ArrayUtil.generateRandomWordArray(inputLength), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctGetRestMethod(String[] words, int index, String[] result) throws Throwable {
        TestOption.incorrectStructureErrorMessage = "Your getRest method should not have printed output.";
        Object[][] arguments = {
                {words, String[].class},
                {index, int.class}
        };
        MethodTest m = new MethodTest(StringSlice.class, "getRest", arguments, methodSentence);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(result, output, "Your getRest method does not return an array with all the strings after an index.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsCorrectOutput(String[] words, int index) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the new array.";
        int length = words.length * 2;
        int count = 0;
        if (index >= 0 && index < words.length) {
            length = (words.length - index) * 2;
            count = index;
        }
        Clause[][] c = new Clause[1][length];
        for (int i = 0; i < c[0].length; i++) {
            c[0][i++] = new StringLiteral(words[count++]);
            c[0][i] = new NewLine();
        }
        runWithInput(ArrayUtil.arrayToInput(words) + index, c);
    }

}
