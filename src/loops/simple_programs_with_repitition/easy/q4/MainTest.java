package loops.simple_programs_with_repitition.easy.q4;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class MainTest extends BaseTest { // Parsons Test

    int input = 9268236;

    public Clause[] testSentence() {
        return new Clause[]{
            new StringLiteral("Enter a number : "),
            new NewLine(),
            new StringLiteral("Reversed Number: "),
            new IntegerLiteral(6000000, 7000000)
        };
    }

    public void runMain() {
        provideInput("" + input);
        ReverseReverse.main(new String[0]);
    }

}
