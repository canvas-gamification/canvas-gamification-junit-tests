package loops.simple_programs_with_repitition.q3;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class DivSeriesTest extends BaseTest {

    int input1 = 20;

    public Clause[] testSentence() {
        return new Clause[] {
                new StringLiteral("Enter a number for the upper bound of the series: "),
                new NewLine(),
                new StringLiteral("The sum of the series is "),
                new IntegerLiteral(seriesDivSum(input1)),
        };
    }

    public void runMain() {
        provideInput("" + input1);
        DivSeries.main(new String[0]);
    }

    public int seriesDivSum(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += 20 / i;
            i++;
        }
        return(sum);
    }
}