package arrays.programs_involving_multidimensional_data.hard.q2;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java

    static final int size = 5;

    public Clause[] testSentence() {
        return clauseBuilder();
    }

    public void runMain(){
        Swapped.main(new String[0]);
    }

    Clause[] clauseBuilder(){
        Clause[] c = new Clause[(size*size*2+size)*2+1];

        int count = 0;

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                c[count++] = new RandomInteger(0, 101, "1r"+x+"c"+y);
                c[count++] = new StringLiteral(" ");
            }
            c[count++] = new NewLine();
        }

        c[count++] = new NewLine();

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                c[count++] = new RandomInteger(0, 101, "2r"+x+"c"+y);
                c[count++] = new StringLiteral(" ");
            }
            c[count++] = new NewLine();
        }

        return c;
    }
}
