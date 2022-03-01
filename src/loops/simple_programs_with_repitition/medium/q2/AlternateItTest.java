package loops.simple_programs_with_repitition.medium.q2;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class AlternateItTest extends BaseTest {

    int input1 = 20;

    public Clause[] testSentence() {
        return new Clause[] {
            new StringLiteral("Enter a number for the upper bound of the series: "),
            new NewLine(),
            new StringLiteral("The sum of the series is "),
            new IntegerLiteral(seriesSum(input1)),
        };
    }

    public void runMain() {
        provideInput("" + input1);
        AlternateIt.main(new String[0]);
    }

    public int seriesSum(int n) {
        int sum  = 0; 
        for(int i = 0; i < n; i++) 
           sum += Math.pow( -1, i ) * ( i + 1 );
        return(sum);
    }
}