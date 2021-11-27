package pre_defined_classes.programs_with_changing_behaviour.easy;

import global.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import temp.RockPaperScissors;

//import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Question1 extends BaseTest {
    /*
     * Programs with Changing Behavior Programs
     * Medium
     * Question 4
     */

    @Test
    public void Player1Test() {
        String testString = "Player One's hand sign is: ";
        RockPaperScissors.main(new String[0]);
        assertTrue(getOutput().contains(testString), "Your program compiled but the code is not correct.");
    }

    @Test
    public void Player2Test() {
        String testString = "Player Two's hand sign is: ";
        RockPaperScissors.main(new String[0]);
        assertTrue(getOutput().contains(testString), "Your program compiled but the code is not correct.");
    }

    @Test
    public void SyntaxTest() {
        try {
            //check if the program can compile
            String testString = "Player One's hand sign is: ";
            RockPaperScissors.main(new String[0]);
            assertTrue(true);
        } catch (Exception e) {
            // catch the exception and give the user a message
            fail("Check your syntax/ordering/types.");
        }
    }
}
