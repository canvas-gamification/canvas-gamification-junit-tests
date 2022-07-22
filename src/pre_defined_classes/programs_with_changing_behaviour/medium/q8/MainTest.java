package pre_defined_classes.programs_with_changing_behaviour.medium.q8;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest  extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Nice! You scored "),
                new RandomInteger(1, 21, "maxScore"), //produce error becuz we are printing the max. Not all the bins are filled, so there's error.
                new StringLiteral(" points this game!")
        };
    }

    public void runMain(){Darts.main(new String[0]);}
}
