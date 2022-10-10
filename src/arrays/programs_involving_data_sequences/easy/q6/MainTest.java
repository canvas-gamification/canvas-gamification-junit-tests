package arrays.programs_involving_data_sequences.easy.q6;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons

    @Override
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "180 65 135 45 187.3 95 67 23 132 78.3 184.78 67.521 704 15.4 63.5 38 374 23.4 437 38";
        return clauseBuilder();
    }

    public void runMain(){
        BMWhy.main(new String[0]);
    }

    public Clause[] clauseBuilder(){
        Clause[] c = new Clause[70];
        int count = 1;

        for(int x = 0; x < 40; x += 4){
            c[x] = new StringLiteral("Enter Height " + count + ": ");
            c[x+1] = new NewLine();
            c[x+2] = new StringLiteral("Enter Weight " + count + ": ");
            c[x+3] = new NewLine();
            count++;
        }

        count = 1;

        for(int x = 40; x < 70; x += 3){
            c[x] = new StringLiteral("BMI " + count + ": ");
            c[x+1] = new DoubleLiteral(String.valueOf(count));
            c[x+2] = new NewLine();
            count++;
        }

        return c;
    }
}
