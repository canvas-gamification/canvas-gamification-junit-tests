package arrays.referencing_array_and_its_elements.medium.q11;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;

public class MainTest extends BaseTest {
    // Java

    public static int n = 30;
    public static char c = 'b';

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(generateRandomWordArray(n));
        return new Clause[]{
                new StringLiteral("Enter " + n + " given names:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("These "),
                new IntegerLiteral("ans"),
                new StringLiteral(" names end with the letter " + c + ":"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder(),
                new Optional(new StringLiteral(" ")),
                new Optional(new NewLine())
        };
    }

    public void runMain() {
        VowelNames.main(new String[0]);
    }


    static Stream<String> inputProvider() {
        return Stream.of(
                arrayToInput(generateRandomWordArray(n)),
                arrayToInput(generateRandomWordArray(n)),
                arrayToInput(generateRandomWordArray(n)),
                arrayToInput(generateRandomWordArray(n)),
                arrayToInput(generateRandomWordArray(n)),
                arrayToInput(generateRandomWordArray(n)),
                arrayToInput(replicateArray(c, n)),
                arrayToInput(replicateArray((char) (c + 1), n))

        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectOutput(String a) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the current names ending with the letter " + c;
        int t = 0;
        String ans = "";
        String temp = "";
        for (int i = 0; i < a.length(); i++) {
            temp += a.charAt(i);
            if (a.charAt(i) == ' ' && a.charAt(i - 1) == c) {
                t++;
                ans += temp;
            }
            if (a.charAt(i) == ' ')
                temp = "";
        }
        runWithInput(a, new Clause[]{
                new StringLiteral(ans)
        });
        CustomAssertions._assertEquals(t, Integer.parseInt(getItemByName("ans")), "Your program does not print the correct number of names that ends with " + c + ".");
    }
}
