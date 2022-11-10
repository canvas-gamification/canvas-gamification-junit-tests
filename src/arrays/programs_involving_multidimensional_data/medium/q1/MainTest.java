package arrays.programs_involving_multidimensional_data.medium.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons with distractors

    /*
    Literally all of this now needs to be changed
     */
    public Clause[] testSentence() {
        return clauseBuilder();
    }

    public void runMain(){
        Identical.main(new String[0]);
    }

    public Clause[] clauseBuilder(){
        Clause[] c = new Clause[113];
        int count = 0;

        for(int x = 0; x <5; x++){
            for(int y = 0; y < 5; y++){
                c[count++] = new RandomInteger(0, 6, "aR"+x+"C"+y);
                c[count++] = new StringLiteral(" ");
            }
            c[count++] = new NewLine();
        }
        c[count++] = new NewLine();
        for(int x = 0; x <5; x++){
            for(int y = 0; y < 5; y++){
                c[count++] = new RandomInteger(0, 6, "bR"+x+"C"+y);
                c[count++] = new StringLiteral(" ");
            }
            c[count++] = new NewLine();
        }
        c[count++] = new NewLine();
        c[count] = new PlaceHolder();

        return c;
    }

    public void placeHolderClauseBuilder(){
        int[][] a = new int[5][5];
        int[][] b = new int[5][5];



        Clause[][] c = new Clause[1][];
    }
}
