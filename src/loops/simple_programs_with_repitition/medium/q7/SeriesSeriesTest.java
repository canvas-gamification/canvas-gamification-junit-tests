package loops.simple_programs_with_repitition.medium.q7;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class SeriesSeriesTest extends BaseTest {

    int input1 = 25;

    public Clause[] testSentence() {
        return new Clause[] {
                new StringLiteral("Enter a number for the upper bound of the series: "),
                new NewLine(),
                new StringLiteral("The sum of the series is "),
                new IntegerLiteral(seriesPectorSum(input1)),
        };
    }

    public void runMain() {
        provideInput("" + input1);
        SeriesSeries.main(new String[0]);
    }

    public int seriesPectorSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum += i * i;
        return (sum);
    }
}