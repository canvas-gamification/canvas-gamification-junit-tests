package arrays.programs_involving_multidimensional_data.easy.q1;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons

    final int size = 4;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1 2 3 4 4 3 2 1 2 4 1 3 3 4 2 1";
        return clauseBuilder();
    }

    public void runMain(){
        AllSameSum.main(new String[0]);
    }

    public Clause[] clauseBuilder(){
        Clause[] c = new Clause[size*size*2+1];

        int count = 0;

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                c[count++] = new StringLiteral("Enter the value for row " + x + " column " + y + ": ");
                c[count++] = new NewLine();
            }
        }

        c[count] = new PlaceHolder();

        return c;
    }
}
