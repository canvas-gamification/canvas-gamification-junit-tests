package loops.simple_programs_with_repitition.medium.q5;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class PerfektKyoobTest extends BaseTest {

    int input1 = 27;

    public Clause[] testSentence() {

        Clause conditional = null;
        if(cubify(input1) == (int) Math.pow(input1, 1 / 3.0))
            conditional = new StringLiteral(" is a Perfect Cube!");
        else
            conditional = new StringLiteral(" is NOT a Perfect Cube!");

        return new Clause[] {
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new IntegerLiteral(input1),
                conditional
        };
    }

    public void runMain() {
        provideInput("" + input1);
        PerfektKyoob.main(new String[0]);
    }

    public int cubify(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n = n / 10;
        }
        return(result);
    }
}