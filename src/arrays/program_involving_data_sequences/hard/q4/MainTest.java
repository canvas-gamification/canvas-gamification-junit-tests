package arrays.program_involving_data_sequences.hard.q4;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    private static final String[] wordBank = new String[]{
            "Hello", "There", "Math", "Pneumonoultramicroscopicsilicovolcanoconiosis", "My", "guacamole", "Chaotic",
            "Computer", "World", "NASA", "Coffee", "glass", "boat", "king", "Zenyatta", "Kelowna", "mouse", "novel",
            "critical", "artificial", "snow", "pattern", "confounded", "visible", "confusion", "ready", "TO", "work",
             "return", "of", "the"
    };

    private static final int wordBankLength = wordBank.length;
    private static final int inputLength = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput =  "Hello how are you today this is my test sentence 5";
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

    private String randomWordInput(){
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < inputLength; i++)
            sb.append(wordBank[r.nextInt(wordBankLength)]).append(" ");
        return sb.toString();
    }

    static Stream<Arguments> methodInputProvider(){
        return Stream.of(Arguments.of(new String[]{"word", "new", "york", "knight", "night", "height", "fight", "flight"}, 5, new String[]{"height", "fight", "flight"}),
                Arguments.of(new String[]{"World", "NASA", "Coffee", "glass", "boat", "king"}, 6, new String[]{}),
                Arguments.of(new String[]{"Hello", "World!", "How", "are", "you", "this", "fine", "summer", "day"}, -11, new String[]{"Hello", "World!", "How", "are", "you", "this", "fine", "summer", "day"}),
                Arguments.of(new String[]{"Hi", "how", "are", "ya"}, -1, new String[]{"Hi", "how", "are", "ya"}),
                Arguments.of(new String[]{"cheese", "intelligent", "farmer", "pork", "dragon", "dawn"}, 0, new String[]{"cheese", "intelligent", "farmer", "pork", "dragon", "dawn"}),
                Arguments.of(new String[]{}, 0, new String[]{}));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctGetRestMethod(String[] words, int index, String[] result) throws Throwable {
        String[] output = (String[]) MethodUtil.invokeIfMethodExists(StringSlice.class, "getRest", new Object[]{words, index},
                String[].class, int.class);
        assertArrayEquals(result, output, "Your method does not return an array with all the words after an index.");
        String methodConsoleOutput = MethodUtil.getMethodOutput();
        assertEquals("", methodConsoleOutput, "Your method should not have any printed output.");
    }

    @Test
    void printsCorrectOutput() throws InvalidClauseException {
        String input = randomWordInput();
        Random r = new Random();
        String[] output = input.split(" ");
        Clause[][] c = new Clause[1][output.length * 2];
        for(int i = 0; i < c[0].length; i+=2){
            c[0][i] = new StringLiteral(output[i/2]);
            c[0][i + 1] = new NewLine();
        }
        runWithInput(input + r.nextInt(inputLength), c);
    }

}
