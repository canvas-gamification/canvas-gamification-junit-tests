package arrays.programs_involving_multidimensional_data.medium.q1;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons with distractors

    static final int size = 5;

    static final int[][] a = {
            {26, 4, 12, 67, 325},
            {89, 448, 59, 32, 5},
            {9, 53, 282, 3, 413},
            {782, 24, 6, 462, 13},
            {40, 12, 424, 404, 9}
    };
    static final int[][] b = {
            {27, 4, 12, 67, 31},
            {89, 4, 59, 32, 5},
            {9, 53, 281, 3, 413},
            {72, 24, 6, 926, 13},
            {42, 12, 424, 414, 9}
    };

    public Clause[] testSentence() {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print out the indexes where the arrays differ.";
        return clauseBuilder();
    }

    public void runMain() {
        Identical.main(new String[0]);
    }

    public Clause[] clauseBuilder() {
        String[] differences = collectDifferences();

        Clause[] c = new Clause[differences.length * 2];
        int count = 0;

        for(int x = 0; x < differences.length; x++){
            c[count++] = new StringLiteral(differences[x]);
            c[count++] = new NewLine();
        }

        return c;
    }

    public String[] collectDifferences(){
        int c = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] != b[i][j])
                    c++;

        String[] dif = new String[c];

        c = 0;

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] != b[i][j])
                    dif[c++] = "The elements at index \\[" + i + "\\]\\[" + j + "\\] are different";

        return dif;
    }
}
