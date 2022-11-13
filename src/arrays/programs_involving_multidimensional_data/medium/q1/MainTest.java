package arrays.programs_involving_multidimensional_data.medium.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons with distractors

    /*
    Literally all of this now needs to be changed
     */
    static final int size = 5;

    public Clause[] testSentence() {
        return clauseBuilder();
    }

    public void runMain() {
        Identical.main(new String[0]);
    }

    public Clause[] clauseBuilder() {
        Clause[] c = new Clause[size * 2 + 1];
        int count = 0;

        for (int x = 0; x < size; x++) {
            c[count++] = new StringLiteral("Enter " + size + " values for array a row " + x + ": ");
            c[count++] = new NewLine();
        }
        c[count++] = new NewLine();
        for (int x = 0; x < 5; x++) {
            c[count++] = new StringLiteral("Enter " + size + " values for array b row " + x + ": ");
            c[count++] = new NewLine();
        }
        c[count] = new PlaceHolder();

        return c;
    }

    public Clause[][] placeHolderClauseBuilder(int[][] a, int[][] b) {
        int differences = 0;

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                if(a[x][y] != b[x][y])
                    differences++;
            }
        }

        Clause[][] c = new Clause[1][differences*2];
        int count = 0;

        for(int x = 0; x < differences; x++){
            c[0][count++] = new StringLiteral("different");
            c[0][count++] = new NewLine();
        }

        return c;
    }
}
