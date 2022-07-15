package arrays.programs_involving_data_sequences.hard.q3;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    private static final int numChars = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = randomCharInputGenerator(numChars) + "2 " + "7 ";
        return new Clause[]{
                new StringLiteral("Enter the character array:"),
                new NewLine(),
                new StringLiteral("Enter the starting index:"),
                new NewLine(),
                new StringLiteral("Enter the ending index:"),
                new NewLine(),
                new StringLiteral("Your string is:"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        SubThat.main(new String[0]);
    }

    private static String randomCharInputGenerator(int length) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            sb.append((char) (r.nextInt(26) + 97));
            sb.append(" ");
        }
        return sb.toString();
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(Arguments.of(new char[]{'a', 'p', 'p', 'l', 'e', 'i', 's', 'b', 'a', 'd'}, 0, 4, "appl"),
                Arguments.of(new char[]{'h', 'f', 'j', 'z', 'w'}, 0, 8, ""),
                Arguments.of(new char[]{}, 0, 4, ""),
                Arguments.of(new char[]{'a', 'z', 'x', 'w', 'q', 's', 'p', 'e', 'f', 'e', 'e', 'g', 'k', 'z', 'a', 'e'}, 5, 4, ""),
                Arguments.of(new char[]{'a', 'b', 'c', 'd', 'z', 'g', 'l'}, 4, 4, ""),
                Arguments.of(new char[]{'f', 'd', 'z', 'q', 'e', 't', 'y', 'p', 'e', 'z', 'w', 'z', 'm', 'n'}, 7, 14, "pezwzmn"));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        Random r = new Random();
        return Stream.of(Arguments.of(randomCharInputGenerator(numChars), numChars / 2, numChars),
                Arguments.of(randomCharInputGenerator(numChars), 0, numChars),
                Arguments.of(randomCharInputGenerator(numChars), numChars - 1, numChars + 1),
                Arguments.of(randomCharInputGenerator(numChars), -1, 5),
                Arguments.of(randomCharInputGenerator(numChars), r.nextInt(numChars), r.nextInt(numChars)));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctSubCharacterStringMethod(char[] input, int start, int end, String subString) throws Throwable {
        String methodOutput = (String) MethodUtil.invokeIfMethodExists(SubThat.class, "subCharacterString",
                new Object[]{input, start, end}, char[].class, int.class, int.class);
        assertEquals(subString, methodOutput, "Your method does not generate the correct substring based on the inputs provided.");
        String consoleOutput = MethodUtil.getMethodOutput();
        assertEquals("", consoleOutput, "Your method should not print anything to the console.");
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
