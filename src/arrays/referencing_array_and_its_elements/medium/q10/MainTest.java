package arrays.referencing_array_and_its_elements.medium.q10;

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
    public static char ch = 'B';

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(generateRandomWordArray(n));
        return new Clause[]{
            new StringLiteral("Enter " + n + " given names:"),
            new Optional(new StringLiteral(" ")),
            new NewLine(),
            new StringLiteral("These are the "),
            new IntegerLiteral("ans"),
            new StringLiteral(" names that start with the letter " + ch + ":"),
            new Optional(new StringLiteral(" ")),
            new NewLine(),
            new PlaceHolder(),
            new Optional(new StringLiteral(" "))
        };
    }

    public void runMain() {
        VowelNames.main(new String[0]);
    }

    public static String randStr() {
        String[] st = generateRandomWordArray(n);
        for(int i = 0; i < n; i ++){
            st[i] = (char)(st[i].charAt(0) - 'a' + 'A') + st[i].substring(1);
        }
        return arrayToInput(st);
    }

    static Stream<String> inputProvider() {
        String[] t1 = new String[n];
        for(int i = 0; i < n; i ++){
            t1[i] = ch + "";
        }
        String[] t2 = new String[n];
        for(int i = 0; i < n; i ++){
            t2[i] = (char)(ch + 1) + "";
        }
        return Stream.of(
                randStr(),
                randStr(),
                randStr(),
                randStr(),
                randStr(),
                arrayToInput(t1),
                arrayToInput(t2)

        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectOutput(String st) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct names starting with the lettter" + ch + ".";
        int t = 0;
        String ans = "";
        boolean flg = false;
        for(int i = 0; i < st.length(); i ++){
            if(st.charAt(i) == ch) {
                t ++;
                flg = true;
            }
            if(flg)
                ans += st.charAt(i);
            if(st.charAt(i) == ' ')
                flg = false;
        }
        runWithInput(st, new Clause[]{
                new StringLiteral(ans.trim())
        });
        CustomAssertions._assertEquals(t, Integer.parseInt(getItemByName("ans")), "Your program does not print the correct number of names starting with " + ch + ".");
    }
}
