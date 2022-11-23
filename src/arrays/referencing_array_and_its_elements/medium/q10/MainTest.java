package arrays.referencing_array_and_its_elements.medium.q10;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;
import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public static int n = 6;
    public static char c = 'B';

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(replicateArray('A', n));
        return new Clause[]{
                new StringLiteral("Enter " + n + " given names:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("There are "),
                new IntegerLiteral("ans"),
                new StringLiteral(" names that start with the letter B"),
                new Optional(new StringLiteral("."))
        };
    }

    public void runMain() {
        VowelNames.main(new String[0]);
    }

    public static String randStr() {
        Random r = new Random();
        String ans = "";
        for (int i = 0; i < n; i++) {
            int up = r.nextInt(20) + 1;
            String st = "" + (char) ('A' + r.nextInt(26));
            for (int j = 1; j < up; j++)
                st += "" + (char) ('a' + r.nextInt(26));
            ans += st + " ";
        }

        return ans.trim();
    }

    static Stream<String> inputProvider() {
        return Stream.of(
                randStr(),
                randStr(),
                randStr(),
                randStr(),
                randStr(),
                randStr(),
                arrayToInput(replicateArray(c, n)),
                arrayToInput(replicateArray((char) (c + 1), n))

        );
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void printsCorrectOutput(String a) {
        int t = 0;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) == c)
                t++;
        runWithInput(a);
        assertEquals(t, Integer.parseInt(getItemByName("ans")));
    }

}
