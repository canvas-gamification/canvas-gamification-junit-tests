package pre_defined_classes.programs_with_changing_behaviour.medium.q5;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The weather predicted is: "),
                new RandomInteger(0, 4, "remainderVal")
        };
    }

    public void runMain() {
        WeatherWizard.main(new String[0]);
    }
}
