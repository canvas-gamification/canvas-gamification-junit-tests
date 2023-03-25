package arrays.programs_involving_multidimensional_data.medium.q5;

import global.BaseRandomTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors

    public static final int n = 2;
    public static final int m = 13;
    public static final char start = 97;

    public Clause[] testSentence() {
        TestOption.incorrectStructureErrorMessage = "Your program does correctly create and print the specified character array.";
        Clause[] c = new Clause[n * m + n];
        int t = 0;
        char ch = start;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                c[t++] = new StringLiteral("" + (ch++));
            c[t++] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        CharOutput.main(new String[0]);
    }
}
