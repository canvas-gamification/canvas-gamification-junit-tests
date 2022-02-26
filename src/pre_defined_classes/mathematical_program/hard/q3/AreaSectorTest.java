package pre_defined_classes.mathematical_program.hard.q3;

import global.BaseTest;
import global.variables.Clause;
import global.variables.NewLine;
import global.variables.RandomInteger;
import global.variables.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;
import temp.Example;

public class AreaSectorTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The area of the sector is: 24.801128670839425")
        };
    }

    public void runMain() {
        AreaSector.main(new String[]{});
    }

    @Test
    public void mathTest(){
        //test that the math is incorrect, not just the formatting
    }
}
