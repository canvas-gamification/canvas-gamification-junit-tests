package loops.simple_programs_with_repitition.medium.q4;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class SerieslyQuestionMarkTest extends BaseTest {

    int input1 = 20;

    public Clause[] testSentence() {
        return new Clause[] {
                new StringLiteral("Enter a number for the upper bound of the series: "),
                new NewLine(),
                new StringLiteral("The sum of the series is "),
                new IntegerLiteral(seriesQuestionMark(input1)),
        };
    }

    public void runMain() {
        provideInput("" + input1);
        SerieslyQuestionMark.main(new String[0]);
    }

    public int seriesQuestionMark(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++)
            sum += i / n;
        return(sum);
    }
} 