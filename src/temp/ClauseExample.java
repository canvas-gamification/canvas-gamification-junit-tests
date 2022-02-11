package temp;

import global.BaseTest;
import global.variables.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClauseExample extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("This is a random test with retrieval."),
                new NewLine(),
                new Optional(new RandomInteger(0, 10)),
        };
    }

    public void runMain() {
        Example.main(new String[]{});
    }

    @RepeatedTest(50)
    public void retrieveValueTest() {
//        int randomIntegerValue = Integer.parseInt(getItemAtIndex(3));
        if (getItemAtIndex(3) != null) {
            int randomIntegerValue = Integer.parseInt(getItemAtIndex(3));
            System.out.println(randomIntegerValue);
            assertEquals(11, randomIntegerValue);
        }
    }
}
