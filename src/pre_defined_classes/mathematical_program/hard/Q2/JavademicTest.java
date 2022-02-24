package pre_defined_classes.mathematical_program.hard.Q2;

import global.BaseTest;
import global.variables.*;

public class JavademicTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("It will take "),
                new IntegerLiteral(40),
                new StringLiteral(" days to infect "),
                new IntegerLiteral(1000000),
                new StringLiteral(" people"),
        };
    }

    public void runMain() {
        Javademic.main(new String[]{});
    }
}
