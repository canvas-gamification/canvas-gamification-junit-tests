package pre_defined_classes.programs_with_changing_behaviour.medium.q9;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest  extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The character age is: "),
                new RandomInteger(1, 51, "age"),
                new NewLine(),
                new StringLiteral("The character height is: "),
                new RandomInteger(50, 201, "height")
        };
    }

    public void runMain(){PlayerCharacteristics.main(new String[0]);}
}
