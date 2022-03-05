package conditionals.simple_programs_with_decision_points.hard.q3;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import temp.Example;

public class SleepyTimeTest extends BaseTest {

    //test if greater than 21 but not greater than 30 mins
    //test if not greater than 21 but greater than 30 mins
    //test above
    //test below

    public Clause[] testSentence() {
//        provideInput("22 45");
        return new Clause[]{
                new StringLiteral("Current Time Hours (in a 24h clock): "),
//                new NewLine(),
//                new StringLiteral("Current Time Minutes:  "),
//                new NewLine(),
//                new StringLiteral("Please go to sleep.")
        };
    }

    public void runMain() {
        SleepyTime.main(new String[]{});
    }
}
