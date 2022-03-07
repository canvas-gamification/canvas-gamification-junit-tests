package temp;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.exceptions.InvalidTestOptionException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ClauseExample extends BaseTest {
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "something";

        return new Clause[]{
                new StringLiteral("This is a test with retrieval."),
                new NewLine(),
                new PlaceHolder(),
                new NewLine(),
                new RandomInteger(0, 10),
        };
    }

    public void runMain() {
        Example.main(new String[0]);
    }

    static Stream<String> inputProvider() {
        return Stream.of("apple", "banana");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String input) throws InvalidClauseException {
        runWithInput(input, new Clause[]{
                new StringLiteral(input, "injected")
        });
        assertEquals(getItemByName("injected"), input);
    }

    @RepeatedTest(50)
    public void retrieveValueTest() {
//        int randomIntegerValue = Integer.parseInt(getItemAtIndex(3));
        if (getItemAtIndex(3) != null) {
            int randomIntegerValue = Integer.parseInt(getItemAtIndex(5));
            System.out.println(randomIntegerValue);
            assertNotEquals(randomIntegerValue, -1);
        }
    }
}
